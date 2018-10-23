package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.AsignacionVista;

public class AsignacionVistaRM implements RowMapper<AsignacionVista> {

	@Override
	public AsignacionVista mapRow(ResultSet rs, int i) throws SQLException {
		AsignacionVista av = new AsignacionVista();
		
		av.setId(rs.getInt("id"));
		av.setNumero_socio(rs.getInt("numero_socio"));
		av.setNombre(rs.getString("nombre"));
		av.setApellido_paterno(rs.getString("apellido_paterno"));
		av.setApellido_materno(rs.getString("apellido_materno"));
		av.setDia(rs.getString("dia"));
		av.setHora_inicial(rs.getTime("hora_inicial"));
		av.setHora_final(rs.getTime("hora_final"));
		
		return av;
	}

}
