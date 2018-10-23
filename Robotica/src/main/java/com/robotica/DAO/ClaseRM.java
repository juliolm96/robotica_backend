package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Clase;

public class ClaseRM implements RowMapper<Clase>{

	@Override
	public Clase mapRow(ResultSet rs, int i) throws SQLException {
		
		Clase c = new Clase();
		
		c.setId(rs.getInt("id"));
		c.setFecha(rs.getDate("fecha"));
		c.setClases_tomadas(rs.getInt("clases_tomadas"));
		c.setHora_entrada(rs.getString("hora_entrada"));
		c.setHora_salida(rs.getString("hora_salida"));
		c.setSocioId(rs.getInt("SOCIO_id"));
		
		return c;
	}

}
