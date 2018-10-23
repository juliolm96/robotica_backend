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

import com.robotica.models.Suscripcion;
import com.robotica.services.SuscripcionService;


@RestController
@RequestMapping("robotica/suscripciones")
public class WSSuscripcion {

	private static final Log bitacora = LogFactory.getLog(WSSuscripcion.class);

	@Autowired
	SuscripcionService suscripcionService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<Suscripcion>> consultar() {

		List<Suscripcion> suscripcionesList;

		try {
			suscripcionesList = suscripcionService.consultar();
			if (suscripcionesList.isEmpty()) {
				return new ResponseEntity<List<Suscripcion>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<List<Suscripcion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Suscripcion>>(suscripcionesList, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Suscripcion> buscar(@PathVariable("id") int id) {

		Suscripcion suscripcion = null;

		try {
			suscripcion = suscripcionService.buscar(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Suscripcion>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Suscripcion>(suscripcion, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<Void> crear(@RequestBody Suscripcion s) {

		bitacora.info(s);

		try {
			suscripcionService.crear(s);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Suscripcion s) {

		bitacora.info(s);

		try {
			suscripcionService.actualizar(s);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

}
