package com.robotica.REST;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robotica.models.Clase_Modelo;
import com.robotica.models.Modelo;
import com.robotica.models.ModeloVista;
import com.robotica.services.ModeloService;

@Controller
@RequestMapping("robotica/modelos")
public class WSModelo {

	private static final Log bitacora = LogFactory.getLog(WSModelo.class);

	@Autowired
	ModeloService modeloService;

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping
	public ResponseEntity<List<Modelo>> consultar() {
		
		List<Modelo> modelosList = null;
		try {
			modelosList = modeloService.consultar();
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<List<Modelo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Modelo>>(modelosList, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/{id}")
	public ResponseEntity<Modelo> buscar(@PathVariable("id") int id) {
		
		Modelo modelo = null;
		try {
			modelo = modeloService.buscar(id);
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<Modelo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Modelo>(modelo, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/vistas")
	public ResponseEntity<List<ModeloVista>> consultarVistas() {
		
		List<ModeloVista> modelosList = null;
		try {
			modelosList = modeloService.consultarVistas();
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<List<ModeloVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ModeloVista>>(modelosList, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/vistas/{id}")
	public ResponseEntity<ModeloVista> buscarVista(@PathVariable("id") int id) {
		
		ModeloVista modeloVista = null;
		try {
			modeloVista = modeloService.buscarVista(id);
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<ModeloVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ModeloVista>(modeloVista, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/vistas/buscar_por_paquete/{paquete_id}")
	public ResponseEntity<List<ModeloVista>> buscarModelosPorPaqueteId(@PathVariable("paquete_id") int paqueteId) {
		List<ModeloVista> modelos = null;
		try {
			
			modelos = modeloService.consultarModelosPorPaquete(paqueteId);
			
			if (modelos.isEmpty()) {
				return new ResponseEntity<List<ModeloVista>>(HttpStatus.NO_CONTENT);
			}
			
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<List<ModeloVista>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<ModeloVista>>(modelos, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/vistas/realizados/{socio_id}")
	public ResponseEntity<List<Clase_Modelo>> modelosHechosPorSocio(@PathVariable("socio_id")int socioId) {
		List<Clase_Modelo> listaModelos = new ArrayList<>();
		
		try {
			listaModelos = modeloService.consultarModelosHechosPorSocio(socioId);
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<List<Clase_Modelo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<Clase_Modelo>>(listaModelos, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<Void> crear(@RequestBody Modelo modelo) {

		try {
			modeloService.crear(modelo);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Modelo modelo) {
		
		try {
			modeloService.actualizar(modelo);
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
