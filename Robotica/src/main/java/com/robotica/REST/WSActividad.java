package com.robotica.REST;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robotica.models.Actividad;
import com.robotica.services.ActividadService;

@RestController
@RequestMapping("robotica/actividad")
public class WSActividad {
	
	private static final Log bitacora = LogFactory.getLog(WSActividad.class);
	
	@Autowired
	ActividadService actividadService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<Void> insertarActividad(@RequestBody Actividad actividad) {
		
		try {
			actividadService.crear(actividad);
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		
	}

}
