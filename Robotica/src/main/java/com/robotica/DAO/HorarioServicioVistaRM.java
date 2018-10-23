package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.HorarioServicioVista;

public class HorarioServicioVistaRM implements RowMapper<HorarioServicioVista> {

	@Override
	public HorarioServicioVista mapRow(ResultSet rs, int i) throws SQLException {
		
		HorarioServicioVista hsv = new HorarioServicioVista();
		
		hsv.setId(rs.getInt("id"));
		hsv.setDia(rs.getString("dia"));
		hsv.setHora_inicial(rs.getTime("hora_inicial"));
		hsv.setHora_final(rs.getTime("hora_final"));
		hsv.setCapacidad(rs.getInt("capacidad"));
		hsv.setDisponible(rs.getInt("disponible"));
		
		return hsv;
	}

}
