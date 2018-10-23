package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robotica.DAO.DetalleTicketDAO;
import com.robotica.models.DetalleTicket;
import com.robotica.models.DetalleTicketVista;

@Service
@Transactional
public class LogicaDetalleTicket implements DetalleTicketService {

	@Autowired
	DetalleTicketDAO dtDAO;

	@Override
	public List<DetalleTicketVista> consultar(int ticketId) {
		return dtDAO.consultar(ticketId);
	}

	@Override
	public void actualizarCantidad(DetalleTicket detalletTicket) {
		dtDAO.actualizarCantidad(detalletTicket);
	}

	@Override
	public void eliminar(int detalleTicketId) {
		dtDAO.eliminar(detalleTicketId);
	}

	@Override
	public int crear(DetalleTicket detalleTicket) {
		return dtDAO.crear(detalleTicket);
	}

	@Override
	public int verificar(DetalleTicket detalleTicket) {
		return dtDAO.verificar(detalleTicket);
	}

}
