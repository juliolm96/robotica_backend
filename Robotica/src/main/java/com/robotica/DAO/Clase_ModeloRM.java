package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Clase_Modelo;

public class Clase_ModeloRM implements RowMapper<Clase_Modelo>{

	@Override
	public Clase_Modelo mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Clase_Modelo clase_modelo = new Clase_Modelo();
		
		clase_modelo.setClaseId(rs.getInt("claseId"));
		clase_modelo.setDescripcion(rs.getString("descripcion"));
		clase_modelo.setId(rs.getInt("id"));
		clase_modelo.setImagen(new String(Base64.encodeBase64(rs.getBytes("imagen"))));
		clase_modelo.setNombre("nombre");
		clase_modelo.setNombre_paquete(rs.getString("nombre_paquete"));
		clase_modelo.setPaqueteId(rs.getInt("PAQUETE_id"));
		clase_modelo.setAlcance(rs.getString("alcance"));
		
		return clase_modelo;
	}

}
