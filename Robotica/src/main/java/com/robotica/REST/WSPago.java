package com.robotica.REST;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robotica.models.Pago;
import com.robotica.models.PagoVista;
import com.robotica.services.PagoService;

@RestController
@RequestMapping("robotica/pagos")
public class WSPago {
	
	private static final Log bitacora = LogFactory.getLog(WSPago.class);
	
	@Autowired
	PagoService pagoService;
	
	@GetMapping
	public ResponseEntity<List<Pago>> consultar(){
		
		List<Pago> pago = null;
		
		try{
			
			pago = pagoService.consultar();
			if(pago.isEmpty()){
				return new ResponseEntity<List<Pago>>(pago,HttpStatus.NO_CONTENT);
			}
		}catch(Exception e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<Pago>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<Pago>>(pago,HttpStatus.OK);
		
	}
	
	@GetMapping("/vista")
	public ResponseEntity<List<PagoVista>> consultarVista(){
		
		List<PagoVista> pago = null;
		
		try{
			
			pago = pagoService.consultarVista();
			if(pago.isEmpty()){
				return new ResponseEntity<List<PagoVista>>(pago,HttpStatus.NO_CONTENT);
			}
		}catch(Exception e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<PagoVista>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<PagoVista>>(pago,HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pago> buscar(@PathVariable("id") int id){
		
		Pago pago = null;
		
		try{
			pago = pagoService.buscar(id);
		}catch(Exception e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Pago>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Pago>(pago,HttpStatus.OK);
		
	}
	
	@GetMapping("/vista/{id}")
	public ResponseEntity<PagoVista> buscarVista(@PathVariable("id") int id){
		
		PagoVista pagoVista = null;
		
		try{
			pagoVista = pagoService.buscarVista(id);
		}catch(Exception e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<PagoVista>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<PagoVista>(pagoVista,HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Void> crear(@RequestBody Pago p){
	
		try{
			
			pagoService.crear(p);
		
		}catch(Exception e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Pago p){
		
		try{
			pagoService.actualizar(p);
		}catch(Exception e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
