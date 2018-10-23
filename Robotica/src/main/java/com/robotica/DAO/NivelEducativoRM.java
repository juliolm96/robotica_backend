package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.NivelEducativo;

public class NivelEducativoRM implements RowMapper<NivelEducativo> {

	@Override
	public NivelEducativo mapRow(ResultSet rs, int i) throws SQLException {
		NivelEducativo ne = new NivelEducativo();
		
		ne.setId(rs.getInt("id"));
		ne.setDescripcion(rs.getString("descripcion"));		
		return ne;
	}

	
}
