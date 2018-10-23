package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Modelo;

public class ModeloRM implements RowMapper<Modelo> {

	@Override
	public Modelo mapRow(ResultSet rs, int i) throws SQLException {
		Modelo modelo = new Modelo();
		
		modelo.setId(rs.getInt("id"));
		modelo.setNombre(rs.getString("nombre"));
		modelo.setDescripcion(rs.getString("descripcion"));
		modelo.setImagen(new String(Base64.encodeBase64(rs.getBytes("imagen"))));
		modelo.setPaquete_id(rs.getInt("PAQUETE_id"));
		
		return modelo;
	}

}
