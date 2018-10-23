package com.robotica.DAO;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.robotica.models.Actividad;
import com.robotica.models.ActividadVista;

@Repository
public class JDBCActividad implements ActividadDAO {

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public void crear(Actividad actividad) {
	
		jdbc.update("INSERT INTO `Robotica`.`actividades` (alcance, MODELO_id, CLASE_id) VALUES (?,?,?)", 
		 		actividad.getAlcance().substring(0, 1), actividad.getModeloId(), actividad.getClaseId());
		
	}

	@Override
	public void modificar(Actividad actividad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ActividadVista> consultarPorSocio(int socioId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActividadVista> consultarPorClase(int claseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActividadVista> consultarPorFechaAndSocio(Date fecha, int socioId) {
		// TODO Auto-generated method stub
		return null;
	}

}
