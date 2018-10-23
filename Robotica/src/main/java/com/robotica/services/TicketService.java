package com.robotica.services;

import java.util.List;

import com.robotica.models.Ticket;
import com.robotica.models.TicketVista;

public interface TicketService {
	
	public TicketVista buscar(int ticketId);
	public List<TicketVista> consultar();
	public int crear(Ticket ticket);
	public void cancelar(int ticketId);
	public void pagar(Ticket ticket);
	
}
