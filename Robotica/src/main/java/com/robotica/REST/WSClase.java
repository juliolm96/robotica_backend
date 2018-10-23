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

import com.robotica.models.Clase;
import com.robotica.services.ClaseService;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("robotica/clases")
public class WSClase {

	private static final Log bitacora = LogFactory.getLog(WSClase.class);

	@Autowired
	ClaseService claseService;

	@GetMapping
	public ResponseEntity<List<Clase>> consultar() {

		List<Clase> claseList = null;

		try {
			claseList = claseService.consultar();
			if (claseList.isEmpty()) {
				return new ResponseEntity<List<Clase>>(claseList, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<Clase>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Clase>>(claseList, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Clase> buscar(@PathVariable("id") int id) {

		Clase clase = null;

		try {
			clase = claseService.buscar(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Clase>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Clase>(clase, HttpStatus.OK);

	}
	
	@GetMapping("/ultima-semana/{socioId}")
	public ResponseEntity<List<Clase>> getClasesDeLaUltimaSemana(@PathVariable("socioId") int socioId) {
		
		List<Clase> clasesList = null;
		
		try {
			
			clasesList = claseService.consultarUltimaSemana(socioId);
			
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<Clase>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<Clase>>(clasesList, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> crear(@RequestBody Clase c) {
		
		try {
			claseService.crear(c);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			String message = "";
			if(e.getCause().toString().split(":").length >= 2) {
				message = e.getCause().toString().split(":")[1];
			}
			if (message.contains(" No es posible")) {
				return new ResponseEntity<Void>(HttpStatus.PRECONDITION_REQUIRED);
			} else {
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
		}

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Clase c) {

		try {
			claseService.actualizar(c);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
