package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.ActividadVista;

public class ActividadVistaRM implements RowMapper<ActividadVista>{

	@Override
	public ActividadVista mapRow(ResultSet rs, int rowNum) throws SQLException {
		ActividadVista av = new ActividadVista();
		
		av.setId(rs.getInt("id"));
		av.setAlcance(rs.getString("alcance"));
		av.setClaseId(rs.getInt("CLASE_id"));
		av.setFecha(rs.getString("fecha"));
		av.setModeloId(rs.getInt("MODELO_id"));
		av.setNombreModelo(rs.getString("nombre_modelo"));
		av.setNombrePaquete(rs.getString("nombre_paquete"));
		
		return null;
	}

}
