package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.ProductoVista;

public class ProductoVistaRM implements RowMapper<ProductoVista>{

	@Override
	public ProductoVista mapRow(ResultSet rs, int arg1) throws SQLException {
		
		ProductoVista productoVista = new ProductoVista();
		
		productoVista.setArticuloId(rs.getInt("articuloId"));
		productoVista.setCodigo(rs.getString("codigo"));
		productoVista.setConcepto(rs.getString("concepto"));
		productoVista.setExistencias(rs.getInt("existencias"));
		try {
			productoVista.setImagen(new String(Base64.encodeBase64(rs.getBytes("imagen"))));
		} catch(Exception e) {
			productoVista.setImagen(null);
		}
		
		productoVista.setPrecio(rs.getFloat("precio"));
		productoVista.setProductoId(rs.getInt("productoId"));
		
		return productoVista;
	}

}
