package com.robotica.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.robotica.models.ServicioVista;

public class ServicioVistaRM implements RowMapper<ServicioVista> {

	@Override
	public ServicioVista mapRow(ResultSet rs, int arg1) throws SQLException {
		
		ServicioVista servicioVista = new ServicioVista();
		
		servicioVista.setArticuloId(rs.getInt("articuloId"));
		servicioVista.setConcepto(rs.getString("concepto"));
		servicioVista.setPrecio(rs.getFloat("precio"));
		servicioVista.setCodigo(rs.getString("codigo"));
		servicioVista.setServicioId(rs.getInt("servicioId"));
		servicioVista.setDias(rs.getInt("dias"));
		servicioVista.setTipo(rs.getString("tipo"));
		servicioVista.setPaqueteId(rs.getInt("paqueteId"));
		servicioVista.setNombrePaquete(rs.getString("nombrePaquete"));
		
		return servicioVista;
	}

}
