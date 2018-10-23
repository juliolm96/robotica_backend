package com.robotica.DAO;

import java.util.List;

import com.robotica.models.Programacion;

public interface ProgramacionDAO {

	public void crear(Programacion p);
	public List<Programacion> consultar();
	public Programacion buscar(int id);
	public void actualizar(Programacion p);
}
