package com.robotica.services;

import java.util.List;

import com.robotica.models.Paquete;
import com.robotica.models.PaqueteVista;

public interface PaqueteService {

	public void crear(Paquete p);
	public void actualizar(Paquete p);
	public Paquete buscar(int id);
	public List<Paquete> consultar();
	public PaqueteVista buscarVista(int id);
	public List<PaqueteVista> consultarVista();
	
}
