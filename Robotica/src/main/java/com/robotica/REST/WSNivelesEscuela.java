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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robotica.models.NivelesEscuelaVista;
import com.robotica.services.NivelesEscuelaService;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("robotica/niveles-escuela")
public class WSNivelesEscuela {

	private static final Log bitacora = LogFactory.getLog(WSNivelesEscuela.class);

	@Autowired
	NivelesEscuelaService nivelesEscuelaService;
	
	
	@PostMapping("/escuela/{id}")
	public ResponseEntity<Void> crear(@PathVariable("id") int idEscuela, @RequestBody String[] niveles){
		
		try{
			nivelesEscuelaService.crearNiveles(idEscuela, niveles);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}catch(DataAccessException e){
			bitacora.info(idEscuela);
			bitacora.info(niveles);
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	@GetMapping("/nivel/{nivel}")
	public ResponseEntity<List<NivelesEscuelaVista>> consultar(@PathVariable String nivel) {
		List<NivelesEscuelaVista> nivelesEscuelaVistaList = null;
		try{
			nivelesEscuelaVistaList = nivelesEscuelaService.consultarPorNivel(nivel);
		}catch(DataAccessException e){
			return new ResponseEntity<List<NivelesEscuelaVista>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<NivelesEscuelaVista>>(nivelesEscuelaVistaList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/consultar-niveles")
	public ResponseEntity<List<String>> consultarEscuelasVista(@PathVariable("id") int id) {
		List<String> escuelasList = null;
		try{
			escuelasList = nivelesEscuelaService.consultarNivelesEscuelas(id);
		}catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<String>>(escuelasList, HttpStatus.OK);
	}
	
	@DeleteMapping("/{idEscuela}")
	public ResponseEntity<Void> eliminar(@PathVariable("idEscuela") int idEscuela, @RequestBody String[] niveles) {
		nivelesEscuelaService.eliminarNiveles(idEscuela, niveles);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
