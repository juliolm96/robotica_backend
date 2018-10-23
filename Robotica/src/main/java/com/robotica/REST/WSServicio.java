package com.robotica.REST;

import java.util.ArrayList;
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

import com.robotica.models.Servicio;
import com.robotica.models.ServicioVista;
import com.robotica.services.ServicioService;

@RestController
@RequestMapping("robotica/servicios")
public class WSServicio {
	
	private static final Log bitacora = LogFactory.getLog(WSServicio.class);
	
	@Autowired
	ServicioService servicioService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping
	public ResponseEntity<List<ServicioVista>> consultar() {
		
		List<ServicioVista> servicioList = new ArrayList<>();
		
		try {
			servicioList = servicioService.consultar();
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<List<ServicioVista>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<ServicioVista>>(servicioList, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/{articuloId}")
	public ResponseEntity<ServicioVista> buscar(@PathVariable("articuloId") int articuloId) {
		ServicioVista servicio = new ServicioVista();
		
		try {
			servicio = servicioService.buscar(articuloId);
		} catch(Exception e) {
			bitacora.error(e);
			return new ResponseEntity<ServicioVista>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ServicioVista>(servicio, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<Void> insertar(@RequestBody Servicio servicio) {
		
		try {
			servicioService.insertar(servicio);
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody ServicioVista servicio) {
		try {
			servicioService.actualizar(servicio);
		} catch(Exception e) {
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	

}
