package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Suscripcion;

public class SuscripcionRM implements RowMapper<Suscripcion>{

	@Override
	public Suscripcion mapRow(ResultSet rs, int i) throws SQLException {

		Suscripcion s = new Suscripcion();
		
		s.setId(rs.getInt("id"));
		s.setMiembroId(rs.getInt("MIEMBRO_id"));
		s.setPaqueteId(rs.getInt("PAQUETE_id"));
		
		return s;
	}

}
