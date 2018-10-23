package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.NivelesEscuelaVista;

public class NivelesEscuelaVistaRM implements RowMapper<NivelesEscuelaVista>{

	@Override
	public NivelesEscuelaVista mapRow(ResultSet rs, int i) throws SQLException {
		
		NivelesEscuelaVista nev = new NivelesEscuelaVista();
		
		nev.setId(rs.getInt("id"));
		nev.setDescripcion(rs.getString("descripcion"));
		nev.setNombre(rs.getString("nombre"));
		
		return nev;
	}

}
