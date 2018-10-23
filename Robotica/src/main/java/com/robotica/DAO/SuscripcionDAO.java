package com.robotica.DAO;

import java.util.List;

import com.robotica.models.Suscripcion;


public interface SuscripcionDAO {

	public void crear(Suscripcion s);
	public Suscripcion buscar(int id);
	public List<Suscripcion> consultar();
	public void actualizar(Suscripcion s);
	
}
