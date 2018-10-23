package com.robotica.REST;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.robotica.models.DetalleTicket;
import com.robotica.models.DetalleTicketVista;
import com.robotica.services.DetalleTicketService;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
@RequestMapping("robotica/detalles_ticket")
public class WSDetalleTicket {

	private static final Log bitacora = LogFactory.getLog(WSDetalleTicket.class);

	@Autowired
	DetalleTicketService dts;

	@GetMapping("/{ticketId}")
	public ResponseEntity<List<DetalleTicketVista>> consultar(@PathVariable("ticketId") int ticketId) {

		List<DetalleTicketVista> listaDetalles = new ArrayList<>();

		try {
			listaDetalles = dts.consultar(ticketId);
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<List<DetalleTicketVista>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<DetalleTicketVista>>(listaDetalles, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody DetalleTicket detalleTicket) {

		try {
			dts.actualizarCantidad(detalleTicket);
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{detalleTicketId}")
	public ResponseEntity<Void> eliminar(@PathVariable("detalleTicketId") int detalleTicketId) {

		try {
			dts.eliminar(detalleTicketId);
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Integer> crear(@RequestBody DetalleTicket detalleTicket) {

		int detalleTicketId = 0;

		try {
			detalleTicketId = dts.verificar(detalleTicket);
		} catch (Exception e) {

		}

		if (detalleTicketId == 0) {
			try {
				detalleTicketId = dts.crear(detalleTicket);
			} catch (Exception e) {
				bitacora.error(e);
				return new ResponseEntity<Integer>(HttpStatus.CONFLICT);
			}

			return new ResponseEntity<Integer>(detalleTicketId, HttpStatus.CREATED);
		} else {
			try {
				detalleTicket.setId(detalleTicketId);
				dts.actualizarCantidad(detalleTicket);
			} catch (Exception e) {
				bitacora.error(e);
				return new ResponseEntity<Integer>(HttpStatus.CONFLICT);
			}

			return new ResponseEntity<Integer>(detalleTicketId, HttpStatus.OK);
		}
	}
}
