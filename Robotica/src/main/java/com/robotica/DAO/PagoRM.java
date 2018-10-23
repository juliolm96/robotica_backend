package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Pago;

public class PagoRM implements RowMapper<Pago>{

	@Override
	public Pago mapRow(ResultSet rs, int i) throws SQLException {
		Pago p = new Pago();
		
		p.setId(rs.getInt("id"));
		p.setFecha(rs.getDate("fecha"));
		p.setNumero(rs.getInt("numero"));
		p.setCantidad(rs.getInt("cantidad"));
		p.setImporte(rs.getFloat("importe"));
		p.setPrecio(rs.getFloat("precio"));
		p.setMiembroId(rs.getInt("MIEMBRO_id"));
		p.setConceptoPagoId(rs.getInt("CONCEPTO_PAGO_id"));
		
		return p;
	}

}
