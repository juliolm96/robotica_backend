package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.ConceptoPago;

public class ConceptoPagoRM implements RowMapper<ConceptoPago> {

	@Override
	public ConceptoPago mapRow(ResultSet rs, int i) throws SQLException {

		ConceptoPago cp = new ConceptoPago();

		cp.setId(rs.getInt("id"));
		cp.setClave(rs.getString("clave"));
		cp.setConcepto(rs.getString("concepto"));
		cp.setNumero_clases(rs.getInt("numero_clases"));
		cp.setPrecio(rs.getFloat("precio"));

		return cp;
	}

}
