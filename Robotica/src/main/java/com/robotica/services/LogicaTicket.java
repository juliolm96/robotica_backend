package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robotica.DAO.TicketDAO;
import com.robotica.models.Ticket;
import com.robotica.models.TicketVista;

@Service
@Transactional
public class LogicaTicket implements TicketService {

	@Autowired
	TicketDAO ticketDAO;
	
	@Override
	public TicketVista buscar(int ticketId) {
		return ticketDAO.buscar(ticketId);
	}

	@Override
	public List<TicketVista> consultar() {
		return ticketDAO.consultar();
	}

	@Override
	public int crear(Ticket ticket) {
		return ticketDAO.crear(ticket);
	}

	@Override
	public void cancelar(int ticketId) {
		ticketDAO.cancelar(ticketId);
	}

	@Override
	public void pagar(Ticket ticket) {
		ticketDAO.pagar(ticket);
	}

}
