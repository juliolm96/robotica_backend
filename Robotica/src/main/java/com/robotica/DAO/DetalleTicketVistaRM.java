package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.DetalleTicketVista;

public class DetalleTicketVistaRM implements RowMapper<DetalleTicketVista> {

	@Override
	public DetalleTicketVista mapRow(ResultSet rs, int i) throws SQLException {
		
		DetalleTicketVista dtv = new DetalleTicketVista();
		
		dtv.setArticuloId(rs.getInt("articuloId"));
		dtv.setCantidad(rs.getInt("cantidad"));
		dtv.setCodigoArticulo(rs.getString("codigoArticulo"));
		dtv.setConceptoArticulo(rs.getString("conceptoArticulo"));
		dtv.setId(rs.getInt("id"));
		dtv.setImporte(rs.getFloat("importe"));
		dtv.setPrecio(rs.getFloat("precio"));
		dtv.setTicketId(rs.getInt("ticketId"));
		
		return dtv;
	}

}
