package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.ModeloDAO;
import com.robotica.models.Clase_Modelo;
import com.robotica.models.Modelo;
import com.robotica.models.ModeloVista;

@Service
public class LogicaModelo implements ModeloService {
	
	@Autowired
	ModeloDAO modeloDAO;
	
	@Override
	public void crear(Modelo modelo) {
		modeloDAO.crear(modelo);
	}

	@Override
	public Modelo buscar(int id) {
		return modeloDAO.buscar(id);
	}

	@Override
	public List<Modelo> consultar() {
		return modeloDAO.consultar();
	}

	@Override
	public void actualizar(Modelo modelo) {
		modeloDAO.actualizar(modelo);		
	}

	@Override
	public ModeloVista buscarVista(int id) {
		return modeloDAO.buscarVista(id);
	}

	@Override
	public List<ModeloVista> consultarVistas() {
		return modeloDAO.consultarVistas();
	}

	@Override
	public List<ModeloVista> consultarModelosPorPaquete(int paqueteId) {
		return modeloDAO.consultarModelosPorPaquete(paqueteId);
	}

	@Override
	public List<Clase_Modelo> consultarModelosHechosPorSocio(int socioId) {
		return modeloDAO.consultarModelosHechosPorSocio(socioId);
	}

}
