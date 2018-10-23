package com.robotica.REST;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robotica.models.Socio;
import com.robotica.models.SocioVista;
import com.robotica.services.SocioService;
import com.robotica.services.SocioVistaService;

@RestController
@RequestMapping("robotica/socios")
// @CrossOrigin(origins = "http://localhost:3000", maxAge = 36000)
public class WSSocio {

	private static final Log bitacora = LogFactory.getLog(WSSocio.class);

	@Autowired
	SocioService socioService;

	@Autowired
	SocioVistaService socioVistaService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<SocioVista>> consultar() {
		List<SocioVista> socioVista = null;

		try {
			socioVista = socioVistaService.consultar();
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<List<SocioVista>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<SocioVista>>(socioVista, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/buscar_numero/{numero}")
	public ResponseEntity<SocioVista> buscarPorNumero(@PathVariable("numero") int numero) {
		SocioVista socioVista = null;

		try {
			socioVista = socioVistaService.buscarPorNumero(numero);
			if (socioVista == null) {
				return new ResponseEntity<SocioVista>(HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			bitacora.error(e);
		}

		return new ResponseEntity<SocioVista>(socioVista, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("buscar_nombre/{nombre}")
	public ResponseEntity<List<SocioVista>> buscarPorNombre(@PathVariable("nombre") String nombre) {
		List<SocioVista> listaSocios = null;
		
		try {
			listaSocios = socioVistaService.buscarPorNombre(nombre);
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<List<SocioVista>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<SocioVista>>(listaSocios, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<SocioVista> buscar(@PathVariable("id") int id) {
		SocioVista socioVista = null;

		try {
			socioVista = socioVistaService.buscar(id);
			if (socioVista == null) {
				return new ResponseEntity<SocioVista>(HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			bitacora.error(e);
		}

		return new ResponseEntity<SocioVista>(socioVista, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<Socio> crear(@RequestBody Socio miembro) {
		Socio socio = null;
		try {
			socio = socioService.crear(miembro);
			return new ResponseEntity<Socio>(socio, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<Socio>(HttpStatus.CONFLICT);
		}
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public ResponseEntity<Socio> actualizar(@RequestBody Socio miembro) {
		Socio socio = null;
		try {
			socio = socioService.actualizar(miembro);
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<Socio>(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Socio>(socio, HttpStatus.OK);
	}

}
