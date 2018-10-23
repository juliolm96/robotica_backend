package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.PagoVista;

public class PagoVistaRM implements RowMapper<PagoVista>{

	@Override
	public PagoVista mapRow(ResultSet rs, int i) throws SQLException {
		PagoVista p = new PagoVista();
		
		p.setId(rs.getInt("id"));
		p.setFecha(rs.getDate("fecha"));
		p.setNumero(rs.getInt("numero"));
		p.setCantidad(rs.getInt("cantidad"));
		p.setImporte(rs.getFloat("importe"));
		p.setPrecio(rs.getFloat("precio"));
		p.setMiembroId(rs.getInt("MIEMBRO_id"));
		p.setConceptoPagoId(rs.getInt("CONCEPTO_PAGO_id"));
		p.setConcepto_letra(rs.getString("concepto_letra"));
		p.setNumero_miembro(rs.getInt("numero_miembro"));
		
		return p;
	}

}
