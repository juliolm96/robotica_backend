package com.robotica.REST;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robotica.models.Asignacion;
import com.robotica.models.AsignacionVista;
import com.robotica.services.AsignacionService;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("robotica/asignaciones")
public class WSAsignacion {
	
	private static final Log bitacora = LogFactory.getLog(WSAsignacion.class);
	
	@Autowired
	AsignacionService asignacionService;
	
	@GetMapping
	public ResponseEntity<List<AsignacionVista>> consultar(){
		List<AsignacionVista> av = null;
		try{
			av = asignacionService.consultar();
		}catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<List<AsignacionVista>>(av, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AsignacionVista>>(av, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AsignacionVista> buscar(@PathVariable("id") int id){
		AsignacionVista av = null;
		
		try{
			av = asignacionService.buscar(id);
		}catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<AsignacionVista>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<AsignacionVista>(av, HttpStatus.OK);
	}
	
	@GetMapping("socio/{numero}")
	public ResponseEntity<List<AsignacionVista>> buscarPorSocio(@PathVariable("numero") int numero){
		List<AsignacionVista> av = null;
		try{
			av = asignacionService.consultarPorSocio(numero);
		}catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<List<AsignacionVista>>(av, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AsignacionVista>>(av, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Void> crear(@RequestBody Asignacion asignacion){
		try{
			asignacionService.crear(asignacion);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Asignacion asignacion){
		try{
			asignacionService.actualizar(asignacion);
		}catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> eliminarAsignacion(@RequestBody int[] ids) {
		asignacionService.eliminar(ids);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
