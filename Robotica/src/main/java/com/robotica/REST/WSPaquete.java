package com.robotica.REST;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.robotica.models.Paquete;
import com.robotica.models.PaqueteVista;
import com.robotica.services.PaqueteService;

@RestController
@RequestMapping("robotica/paquetes")
public class WSPaquete {

	private static final Log bitacora = LogFactory.getLog(WSPaquete.class);

	@Autowired
	PaqueteService paqueteService;

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping
	public ResponseEntity<List<Paquete>> consultar() {

		List<Paquete> paquetesList;

		try {
			paquetesList = paqueteService.consultar();
			if (paquetesList.isEmpty()) {
				return new ResponseEntity<List<Paquete>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<List<Paquete>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Paquete>>(paquetesList, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/{id}")
	public ResponseEntity<Paquete> buscar(@PathVariable("id") int id) {

		Paquete paquete = null;

		try {
			paquete = paqueteService.buscar(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Paquete>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Paquete>(paquete, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/vistas")
	public ResponseEntity<List<PaqueteVista>> consultarVista() {

		List<PaqueteVista> paqueteVistaList;

		try {
			paqueteVistaList = paqueteService.consultarVista();
			if (paqueteVistaList.isEmpty()) {
				return new ResponseEntity<List<PaqueteVista>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<List<PaqueteVista>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<PaqueteVista>>(paqueteVistaList, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/vistas/{id}")
	public ResponseEntity<PaqueteVista> buscarVista(@PathVariable("id") int id) {

		PaqueteVista paqueteVista = null;

		try {
			paqueteVista = paqueteService.buscarVista(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<PaqueteVista>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<PaqueteVista>(paqueteVista, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<Void> crear(@RequestBody Paquete p) {

		try {
			paqueteService.crear(p);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Paquete s) {

		try {
			paqueteService.actualizar(s);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

}
