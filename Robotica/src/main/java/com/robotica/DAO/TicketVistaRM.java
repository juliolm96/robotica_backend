package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.TicketVista;

public class TicketVistaRM implements RowMapper<TicketVista> {

	@Override
	public TicketVista mapRow(ResultSet rs, int i) throws SQLException {
		TicketVista ticketVista = new TicketVista();
		
		ticketVista.setEstado(rs.getString("estado"));
		ticketVista.setFecha(rs.getDate("fecha"));
		ticketVista.setFolio(rs.getString("folio"));
		ticketVista.setForma_pago(rs.getString("forma_pago"));
		ticketVista.setHora(rs.getString("hora"));
		ticketVista.setId(rs.getInt("id"));
		ticketVista.setIva(rs.getFloat("iva"));
		ticketVista.setNombre_socio(rs.getString("nombre_socio"));
		ticketVista.setSocioId(rs.getInt("socioId"));
		ticketVista.setSubtotal(rs.getFloat("subtotal"));
		ticketVista.setTotal(rs.getFloat("total"));
		
		return ticketVista;
	}

}
