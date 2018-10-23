package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.ModeloVista;

public class ModeloVistaRM implements RowMapper<ModeloVista>{

	@Override
	public ModeloVista mapRow(ResultSet rs, int i) throws SQLException {
		
		ModeloVista mv = new ModeloVista();
		
		mv.setId(rs.getInt("id"));
		mv.setNombre(rs.getString("nombre"));
		mv.setDescripcion(rs.getString("descripcion"));
		mv.setImagen(new String(Base64.encodeBase64(rs.getBytes("imagen"))));
		mv.setNombre_paquete(rs.getString("nombre_paquete"));
		mv.setPaqueteId(rs.getInt("PAQUETE_id"));
		
		return mv;
	}

}
