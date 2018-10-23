package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Servicio;

public class ServicioRM implements RowMapper<Servicio>{

	@Override
	public Servicio mapRow(ResultSet rs, int arg1) throws SQLException {
		Servicio servicio = new Servicio();
		
		servicio.setId(rs.getInt("id"));
		servicio.setDias(rs.getInt("dias"));
		servicio.setTipo(rs.getString("tipo"));
		servicio.setArticuloId(rs.getInt("ARTICULO_id"));
		servicio.setPaqueteId(rs.getInt("PAQUETE_id"));
		
		return servicio;
	}

}
