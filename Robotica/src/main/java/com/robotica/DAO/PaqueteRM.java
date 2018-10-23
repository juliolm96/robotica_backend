package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Paquete;

public class PaqueteRM implements RowMapper<Paquete>{

	@Override
	public Paquete mapRow(ResultSet rs, int i) throws SQLException {
		
		Paquete p = new Paquete();
		
		p.setId(rs.getInt("id"));
		p.setDescripcion(rs.getString("descripcion"));
		p.setNombre(rs.getString("nombre"));
		p.setSetId(rs.getInt("SET_id"));
		
		return p;
	}

}
