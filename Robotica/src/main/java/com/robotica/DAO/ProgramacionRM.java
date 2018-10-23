package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Programacion;

public class ProgramacionRM implements RowMapper<Programacion> {

	@Override
	public Programacion mapRow(ResultSet rs, int i) throws SQLException {
		Programacion programacion = new Programacion();
		
		programacion.setId(rs.getInt("id"));
		programacion.setInstruccion(new String(Base64.encodeBase64(rs.getBytes("instruccion"))));
		programacion.setNumero(rs.getInt("numero"));
		programacion.setModelo_id(rs.getInt("MODELO_id"));
		
		return programacion;
	}

}
