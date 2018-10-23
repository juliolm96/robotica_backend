package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.Construccion;

public class ConstruccionRM implements RowMapper<Construccion>{

	@Override
	public Construccion mapRow(ResultSet rs, int i) throws SQLException {
		
		Construccion c = new Construccion();
		
		c.setId(rs.getInt("id"));
		c.setMaterial(new String(Base64.encodeBase64(rs.getBytes("material"))));
		c.setInstruccion(new String(Base64.encodeBase64(rs.getBytes("instruccion"))));
		c.setEnsamblado(new String(Base64.encodeBase64(rs.getBytes("ensamblado"))));
		c.setNumero(rs.getInt("numero"));
		c.setModeloId(rs.getInt("MODELO_id"));
		
		return c;
	}

}
