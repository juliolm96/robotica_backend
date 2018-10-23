package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.SocioVista;

public class SocioVistaRM implements RowMapper<SocioVista>{

	@Override
	public SocioVista mapRow(ResultSet rs, int i) throws SQLException {
		
		SocioVista mv = new SocioVista();
		
		mv.setApellido_materno(rs.getString("apellido_materno"));
		mv.setApellido_paterno(rs.getString("apellido_paterno"));
		mv.setFecha_ingreso(rs.getDate("fecha_ingreso"));
		mv.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
		mv.setId(rs.getInt("id"));
		mv.setNivel_educativo(rs.getString("nivel_educativo"));
		mv.setNombre(rs.getString("nombre"));
		mv.setNombre_escuela(rs.getString("nombre_escuela"));
		mv.setNumero(rs.getInt("numero"));
		mv.setSaldo_clases(rs.getInt("saldo_clases"));
		mv.setTelefono(rs.getString("telefono"));
		mv.setTutor(rs.getString("tutor"));
		
		return mv;
	}

}


