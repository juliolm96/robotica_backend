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

import com.robotica.models.Escuela;
import com.robotica.services.EscuelaService;

@RestController
@RequestMapping("robotica/escuelas")
public class WSEscuela {

	private static final Log bitacora = LogFactory.getLog(WSEscuela.class);

	@Autowired
	EscuelaService escuelaService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping
	public ResponseEntity<List<Escuela>> consultar(){
		List<Escuela> escuelaList = null;
		try{
			escuelaList = escuelaService.consultar();
		}catch(DataAccessException e){
			
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<Escuela>>(HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<List<Escuela>>(escuelaList, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/{id}")
	public ResponseEntity<Escuela> buscar(@PathVariable("id") int id){
		Escuela escuela = null;
		try{
			escuela = escuelaService.buscar(id);
		}catch(DataAccessException e){
			return new ResponseEntity<Escuela>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Escuela>(escuela, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<Void> crear(@RequestBody Escuela escuela){
		try{
			escuelaService.crear(escuela);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Escuela escuela){
		try{
			escuelaService.actualizar(escuela);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(DataAccessException e){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}

}
