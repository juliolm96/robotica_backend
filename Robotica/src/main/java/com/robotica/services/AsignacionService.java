package com.robotica.services;

import java.util.List;

import com.robotica.models.Asignacion;
import com.robotica.models.AsignacionVista;

public interface AsignacionService {

	public void crear(Asignacion asignacion);
	public AsignacionVista buscar(int id);
	public List<AsignacionVista> consultar();
	public void actualizar(Asignacion asignacion);
	public List<AsignacionVista> consultarPorSocio(int numero);
	public void eliminar(int[] ids);
	
}
