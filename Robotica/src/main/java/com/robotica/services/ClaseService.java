package com.robotica.services;

import java.util.List;

import com.robotica.models.Clase;

public interface ClaseService {
	
	public void crear(Clase c);
	public void actualizar(Clase c);
	public Clase buscar(int id);
	public List<Clase> consultar();
	public List<Clase> consultarUltimaSemana(int socioId);
	
}
