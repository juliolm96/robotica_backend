package com.robotica.DAO;

import java.sql.Date;
import java.util.List;

import com.robotica.models.Actividad;
import com.robotica.models.ActividadVista;

public interface ActividadDAO {
	
	public void crear(Actividad actividad);
	public void modificar(Actividad actividad);
	public List<ActividadVista> consultarPorSocio(int socioId);
	public List<ActividadVista> consultarPorClase(int claseId);
	public List<ActividadVista> consultarPorFechaAndSocio(Date fecha, int socioId);
	
}
