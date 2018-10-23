package com.robotica.services;

import java.util.List;

import com.robotica.models.Suscripcion;

public interface SuscripcionService {

	public void crear(Suscripcion s);
	public void actualizar(Suscripcion s);
	public Suscripcion buscar(int id);
	public List<Suscripcion> consultar();
	
}
