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

import com.robotica.models.ConceptoPago;
import com.robotica.services.ConceptoPagoService;

@RestController
@RequestMapping("robotica/conceptos_pago")
public class WSConceptoPago {

	private static final Log bitacora = LogFactory.getLog(WSConceptoPago.class);

	@Autowired
	ConceptoPagoService conceptoPagoService;

	@GetMapping
	public ResponseEntity<List<ConceptoPago>> consultar() {

		List<ConceptoPago> conceptoPagoList;

		try {
			conceptoPagoList = conceptoPagoService.consultar();
			if (conceptoPagoList.isEmpty()) {
				return new ResponseEntity<List<ConceptoPago>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<ConceptoPago>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<ConceptoPago>>(conceptoPagoList, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<ConceptoPago> buscar(@PathVariable("id") int id) {

		ConceptoPago conceptoPago;

		try {
			conceptoPago = conceptoPagoService.buscar(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<ConceptoPago>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ConceptoPago>(conceptoPago,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> crear(@RequestBody ConceptoPago cp){
		
		bitacora.info(cp);
		
		try{
			conceptoPagoService.crear(cp);
		}catch(Exception e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody ConceptoPago cp){
		
		bitacora.info(cp);
		
		try{
			
			conceptoPagoService.actualizar(cp);
			
		}catch(Exception e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	
}
