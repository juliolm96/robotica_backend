package com.robotica.services;

import java.util.List;

import com.robotica.models.Escuela;

public interface EscuelaService {

	public void crear(Escuela escuela);
	public Escuela buscar(int id);
	public List<Escuela> consultar();
	public void actualizar(Escuela escuela);	
}
