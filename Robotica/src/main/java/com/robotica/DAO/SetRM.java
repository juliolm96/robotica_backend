package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Set;

public class SetRM implements RowMapper<Set>{

	@Override
	public Set mapRow(ResultSet rs, int i) throws SQLException {
		
		Set set = new Set();
		
		set.setId(rs.getInt("id"));
		set.setDescripcion(rs.getString("descripcion"));
		set.setNombre(rs.getString("nombre"));
		set.setNumero(rs.getString("numero"));
		
		return set;
	}
	
	

}
