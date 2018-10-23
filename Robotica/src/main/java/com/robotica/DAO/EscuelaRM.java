package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Escuela;

public class EscuelaRM implements RowMapper<Escuela> {

	@Override
	public Escuela mapRow(ResultSet rs, int i) throws SQLException {
		
		Escuela escuela = new Escuela();
		
		escuela.setId(rs.getInt("id"));
		escuela.setClave(rs.getString("clave"));
		escuela.setNombre(rs.getString("nombre"));
		return escuela;
		
	}

	
}
