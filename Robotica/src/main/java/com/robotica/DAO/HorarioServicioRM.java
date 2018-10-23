package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.HorarioServicio;

public class HorarioServicioRM implements RowMapper<HorarioServicio> {

	@Override
	public HorarioServicio mapRow(ResultSet rs, int i) throws SQLException {
		
		HorarioServicio hs = new HorarioServicio();
		
		hs.setId(rs.getInt("id"));
		hs.setDia(rs.getString("dia"));
		hs.setHora_inicial(rs.getTime("hora_inicial"));
		hs.setHora_final(rs.getTime("hora_final"));
		hs.setCapacidad(rs.getInt("capacidad"));
		
		return hs;
	}

}
