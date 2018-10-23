package com.robotica.services;

import java.util.List;

import com.robotica.models.Clase_Modelo;
import com.robotica.models.Modelo;
import com.robotica.models.ModeloVista;

public interface ModeloService {

	public void crear(Modelo modelo);
	public Modelo buscar(int id);
	public List<Modelo> consultar();
	public void actualizar(Modelo modelo);
	public ModeloVista buscarVista(int id);
	public List<ModeloVista> consultarVistas();
	public List<ModeloVista> consultarModelosPorPaquete(int paqueteId);
	public List<Clase_Modelo> consultarModelosHechosPorSocio(int socioId);
	
}
