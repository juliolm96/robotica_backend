package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.NivelesEscuela;

public class NivelesEscuelaRM implements RowMapper<NivelesEscuela>{

	@Override
	public NivelesEscuela mapRow(ResultSet rs, int i) throws SQLException {
		
		NivelesEscuela ne = new NivelesEscuela();
				ne.setId(rs.getInt("id"));
				ne.setEscuelaId(rs.getInt("ESCUELA_id"));
				ne.setNivelEducativoId(rs.getInt("NIVEL_EDUCATIVO_id"));
		return ne;
	}

}
