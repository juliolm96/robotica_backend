package com.robotica.DAO;

import java.util.List;

import com.robotica.models.DetalleTicket;
import com.robotica.models.DetalleTicketVista;

public interface DetalleTicketDAO {
	
	public List<DetalleTicketVista> consultar(int ticketId);
	public void actualizarCantidad(DetalleTicket detalletTicket);
	public void eliminar(int detalleTicketId);
	public int crear(DetalleTicket detalleTicket);
	public int verificar(DetalleTicket detalleTicket);
	
}
