package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.SuscripcionVista;

public class SuscripcionVistaRM implements RowMapper<SuscripcionVista>{

	@Override
	public SuscripcionVista mapRow(ResultSet rs, int i) throws SQLException {
		
		SuscripcionVista suscripcionVista = new SuscripcionVista();
		
		suscripcionVista.setId(rs.getInt("id"));
		suscripcionVista.setNombre_paquete(rs.getString("nombre_paquete"));
		suscripcionVista.setNombre_socio(rs.getString("nombre_socio"));
		suscripcionVista.setPaqueteId(rs.getInt("paqueteId"));
		suscripcionVista.setSocioId(rs.getInt("socioId"));
		suscripcionVista.setVigencia(rs.getString("vigencia"));
		suscripcionVista.setVigente(rs.getInt("vigente"));
		
		return suscripcionVista;
	}

}
