package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Articulo;

public class ArticuloRM implements RowMapper<Articulo>{

	@Override
	public Articulo mapRow(ResultSet rs, int i) throws SQLException {
		Articulo articulo = new Articulo();
		
		articulo.setId(rs.getInt("id"));
		articulo.setConcepto(rs.getString("concepto"));
		articulo.setCodigo(rs.getString("codigo"));
		articulo.setPrecio(rs.getFloat("precio"));
		
		return articulo;
	}

	
	
}
