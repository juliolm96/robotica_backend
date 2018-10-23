package com.robotica.services;

import java.util.List;

import com.robotica.models.Programacion;

public interface ProgramacionService {

	public void crear(Programacion programacion);
	public Programacion buscar(int id);
	public List<Programacion> consultar();
	public void actualizar(Programacion programacion);
}
