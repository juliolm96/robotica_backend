package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.PaqueteVista;

public class PaqueteVistaRM implements RowMapper<PaqueteVista>{

	@Override
	public PaqueteVista mapRow(ResultSet rs, int i) throws SQLException {
		PaqueteVista pv = new PaqueteVista(
				rs.getInt("id"),
				rs.getString("nombre"),
				rs.getString("descripcion"),
				rs.getInt("SET_id"),
				rs.getString("nombre_set")
				);
		
		return pv;
	}

}
