package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Socio;

public class SocioRM implements RowMapper<Socio> {

	@Override
	public Socio mapRow(ResultSet rs, int i) throws SQLException {
		
		Socio miembro = new Socio();
		
		miembro.setId(rs.getInt("id"));
		miembro.setFecha_ingreso(rs.getDate("fecha_ingreso"));
		miembro.setNumero(rs.getInt("numero"));
		miembro.setNombre(rs.getString("nombre"));
		miembro.setApellido_paterno(rs.getString("apellido_paterno"));
		miembro.setApellido_materno(rs.getString("apellido_materno"));
		miembro.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
		miembro.setTutor(rs.getString("tutor"));
		miembro.setTelefono(rs.getString("telefono"));
		miembro.setNivel_educativo(rs.getString("nivel_educativo"));
		miembro.setSaldo_clases(rs.getInt("saldo_clases"));
		miembro.setESCUELA_id(rs.getInt("ESCUELA_id"));
		
		return miembro;
	}

}
