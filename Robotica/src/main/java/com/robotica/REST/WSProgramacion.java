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

import com.robotica.models.Programacion;
import com.robotica.services.ProgramacionService;

@Controller
@RequestMapping("robotica/programacion")
public class WSProgramacion {

	private static final Log bitacora = LogFactory.getLog(WSProgramacion.class);
	
	@Autowired
	ProgramacionService programacionService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping
	public ResponseEntity<List<Programacion>> consultar(){
		List<Programacion> programacionList = null;
		
		try{
			programacionService.consultar();
		}catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<List<Programacion>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Programacion>>(programacionList, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/{id}")
	public ResponseEntity<Programacion> buscar(@PathVariable("id") int id){
		Programacion programacion = null;
		
		try{
			programacionService.buscar(id);
		}catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<Programacion>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Programacion>(programacion, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<Void> crear(@RequestBody Programacion programacion){
		try{
			programacionService.crear(programacion);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Programacion programacion){
		try{
			programacionService.actualizar(programacion);
		}catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
