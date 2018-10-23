package com.robotica.services;

import java.util.List;

import com.robotica.models.Servicio;
import com.robotica.models.ServicioVista;

public interface ServicioService {

	public void insertar(Servicio servicio);
	public void actualizar(ServicioVista servicio);
	public ServicioVista buscar(int id);
	public List<ServicioVista> consultar();
	
}
