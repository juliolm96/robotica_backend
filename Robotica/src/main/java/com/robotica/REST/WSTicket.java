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

import com.robotica.models.Ticket;
import com.robotica.models.TicketVista;
import com.robotica.services.TicketService;

@RestController
@RequestMapping("robotica/tickets")
public class WSTicket {

	private static final Log bitacora = LogFactory.getLog(WSTicket.class);

	@Autowired
	TicketService ticketService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<TicketVista>> consultar() {

		List<TicketVista> listaTickets = new ArrayList<>();

		try {
			listaTickets = ticketService.consultar();
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<List<TicketVista>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<TicketVista>>(listaTickets, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{ticketId}")
	public ResponseEntity<TicketVista> buscar(@PathVariable("ticketId") int ticketId) {

		TicketVista ticketVista = new TicketVista();

		try {
			ticketVista = ticketService.buscar(ticketId);
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<TicketVista>(ticketVista, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<TicketVista>(ticketVista, HttpStatus.OK);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<Integer> crear(@RequestBody Ticket ticket) {
		int ticketId = 0;

		try {
			ticketId = ticketService.crear(ticket);
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<Integer>(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Integer>(ticketId, HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/{ticketId}/cancelar")
	public ResponseEntity<Void> cancelar(@PathVariable("ticketId") int ticketId) {

		try {
			ticketService.cancelar(ticketId);
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/pagar")
	public ResponseEntity<Void> pagar(@RequestBody Ticket ticket) {

		try {
			ticketService.pagar(ticket);
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}