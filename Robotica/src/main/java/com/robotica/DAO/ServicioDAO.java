package com.robotica.DAO;

import java.util.List;

import com.robotica.models.Servicio;
import com.robotica.models.ServicioVista;

public interface ServicioDAO {

	public void insertar(Servicio servicio, int articuloId);

	public void actualizar(ServicioVista servicio);

	public ServicioVista buscar(int articuloId);

	public List<ServicioVista> consultar();
	
}
