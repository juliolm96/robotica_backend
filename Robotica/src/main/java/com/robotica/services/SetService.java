package com.robotica.services;

import java.util.List;

import com.robotica.models.Set;

public interface SetService {
	
	public void crear(Set s);
	public void actualizar(Set s);
	public Set buscar(int id);
	public List<Set> consultar();

}
