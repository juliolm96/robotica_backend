package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.ClaseVista;

public class ClaseVistaRM implements RowMapper<ClaseVista> {

	@Override
	public ClaseVista mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ClaseVista c = new ClaseVista();
		
		c.setId(rs.getInt("id"));
		c.setFecha(rs.getDate("fecha"));
		c.setClases_tomadas(rs.getInt("clases_tomadas"));
		c.setHora_entrada(rs.getString("hora_entrada"));
		c.setHora_salida(rs.getString("hora_salida"));
		c.setSocioId(rs.getInt("SOCIO_id"));
		c.setNombreSocio(rs.getString("nombre_socio"));
		
		return c;
	}

}
