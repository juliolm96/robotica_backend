package com.robotica.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.ActividadDAO;
import com.robotica.models.Actividad;
import com.robotica.models.ActividadVista;

@Service
public class LogicaActividad implements ActividadService {

	@Autowired
	ActividadDAO actividadDAO;
	
	@Override
	public void crear(Actividad actividad) {
		
		actividadDAO.crear(actividad);
		
	}

	@Override
	public void modificar(Actividad actividad) {

		actividadDAO.modificar(actividad);
		
	}

	@Override
	public List<ActividadVista> consultarPorSocio(int socioId) {

		return actividadDAO.consultarPorSocio(socioId);
		
	}

	@Override
	public List<ActividadVista> consultarPorClase(int claseId) {
	
		return actividadDAO.consultarPorClase(claseId);
		
	}

	@Override
	public List<ActividadVista> consultarPorFechaAndSocio(Date fecha, int socioId) {

		return actividadDAO.consultarPorFechaAndSocio(fecha, socioId);
		
	}

}
