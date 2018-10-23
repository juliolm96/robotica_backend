package com.robotica.DAO;

import java.util.List;

import com.robotica.models.Asignacion;
import com.robotica.models.AsignacionVista;

public interface AsignacionDAO {
	public void crear(Asignacion asignacion);
	public AsignacionVista buscar(int id);
	public List<AsignacionVista> consultarPorSocio(int numero);
	public List<AsignacionVista> consultar();
	public void actualizar(Asignacion asignacion);
	public void eliminar(int id);
}
