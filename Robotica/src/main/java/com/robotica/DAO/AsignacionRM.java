package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Asignacion;

public class AsignacionRM implements RowMapper<Asignacion> {

	@Override
	public Asignacion mapRow(ResultSet rs, int i) throws SQLException {
		Asignacion asignacion = new Asignacion();
		
		asignacion.setId(rs.getInt("id"));
		asignacion.setSocio_id(rs.getInt("MIEMBRO_id"));
		asignacion.setHorario_servicio_id(rs.getInt("HORARIO_SERVICIO_id"));
		
		return asignacion;
	}

}
