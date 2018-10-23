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

import com.robotica.models.HorarioServicio;
import com.robotica.models.HorarioServicioVista;
import com.robotica.services.HorarioServicioService;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("robotica/horarios-servicio")
public class WSHorarioServicio {

	private static final Log bitacora = LogFactory.getLog(WSHorarioServicio.class);
	
	@Autowired
	HorarioServicioService horarioServicioService;
	
	@GetMapping
	public ResponseEntity<List<HorarioServicioVista>> consultar(){
		List<HorarioServicioVista> hsv = null;
		
		try{
			hsv = horarioServicioService.consultar();
		}
		catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<List<HorarioServicioVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<HorarioServicioVista>>(hsv,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HorarioServicioVista> buscar(@PathVariable("id") int id){
		HorarioServicioVista hsv = null;
		try{
			hsv = horarioServicioService.buscar(id);
		}catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<HorarioServicioVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HorarioServicioVista>(hsv, HttpStatus.OK);
	}
	
	@GetMapping("/consultar/dia/{dia}")
	public ResponseEntity<List<HorarioServicioVista>> consultarPorDia(@PathVariable("dia") String dia){
		List<HorarioServicioVista> hsv = null;
		try{
			hsv = horarioServicioService.consultarPorDia(dia);
		}catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<List<HorarioServicioVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<HorarioServicioVista>>(hsv, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> crear(@RequestBody HorarioServicio hs){
		try{
			horarioServicioService.crear(hs);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody HorarioServicio hs){
		try{
			horarioServicioService.actualizar(hs);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(DataAccessException e){
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Void> eliminarHorarios(@RequestBody int[] ids) {
		horarioServicioService.eliminarHorarios(ids);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
