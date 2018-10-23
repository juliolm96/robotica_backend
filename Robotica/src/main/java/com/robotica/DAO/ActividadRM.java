package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Actividad;

public class ActividadRM implements RowMapper<Actividad> {

	@Override
	public Actividad mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Actividad a = new Actividad();
		
		a.setId(rs.getInt("id"));
		a.setAlcance(rs.getString("alcance"));
		a.setClaseId(rs.getInt("CLASE_id"));
		a.setModeloId(rs.getInt("MODELO_id"));
		
		return a;
	}

}
