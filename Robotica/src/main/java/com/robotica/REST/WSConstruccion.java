package com.robotica.REST;

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

import com.robotica.models.Construccion;
import com.robotica.services.ConstruccionService;

@Controller
@RequestMapping("robotica/construccion")
public class WSConstruccion {

	private static final Log bitacora = LogFactory.getLog(WSConstruccion.class);

	@Autowired
	ConstruccionService construccionService;

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping
	public ResponseEntity<List<Construccion>> consultar() {
		List<Construccion> construccionList = null;

		try {
			construccionList = construccionService.consultar();
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<List<Construccion>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Construccion>>(construccionList, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Construccion> buscar(@PathVariable("id") int id) {
		Construccion construccion = null;

		try {
			construccion = construccionService.buscar(id);
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<Construccion>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Construccion>(construccion, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<Void> crear(@RequestBody Construccion construccion) {
		try {
			construccionService.crear(construccion);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Construccion construccion) {
		try {
			construccionService.actualizar(construccion);
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/{modeloId}/total-pasos")
	public ResponseEntity<Integer> getTotalPasos(@PathVariable("modeloId") int modeloId) {
		int total = 0;

		try {
			total = construccionService.getNumeroPasos(modeloId);
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<Integer>(total, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Integer>(total, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/{modeloId}/pasos/primero")
	public ResponseEntity<Construccion> getPrimero(@PathVariable("modeloId") int modeloId) {
		Construccion construccion = new Construccion();

		try {
			construccion = construccionService.getPrimero(modeloId);
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<Construccion>(construccion, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Construccion>(construccion, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/{modeloId}/paso/{numeroActual}")
	public ResponseEntity<Construccion> getSiguiente(@PathVariable("modeloId") int modeloId,
			@PathVariable("numeroActual") int numeroActual) {
		Construccion construccion = new Construccion();

		try {
			construccion = construccionService.getSiguiente(modeloId, numeroActual);
		} catch (DataAccessException e) {
			bitacora.error(e);
			return new ResponseEntity<Construccion>(construccion, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Construccion>(construccion, HttpStatus.OK);
	}

}