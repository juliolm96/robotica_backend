package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Producto;

public class ProductoRM implements RowMapper<Producto> {

	@Override
	public Producto mapRow(ResultSet rs, int arg1) throws SQLException {
		Producto p = new Producto();
		
		p.setProductoId(rs.getInt("id"));
		p.setExistencias(rs.getInt("existencias"));
		p.setArticuloId(rs.getInt("ARTICULO_id"));
		try {
			p.setImagen(new String(Base64.encodeBase64(rs.getBytes("imagen"))));
		} catch(Exception e) {
			p.setImagen(null);
		}
		
		return p;
	}

}
