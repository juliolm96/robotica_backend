package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.PaqueteDAO;
import com.robotica.models.Paquete;
import com.robotica.models.PaqueteVista;

@Service
public class LogicaPaquete implements PaqueteService{

	@Autowired
	PaqueteDAO pd;
	
	@Override
	public void crear(Paquete p) {
		pd.crear(p);
	}

	@Override
	public void actualizar(Paquete p) {

		pd.actualizar(p);
		
	}

	@Override
	public Paquete buscar(int id) {

		return pd.buscar(id);
		
	}

	@Override
	public List<Paquete> consultar() {
		
		return pd.consultar();
		
	}

	@Override
	public PaqueteVista buscarVista(int id) {
		return pd.buscarVista(id);
	}

	@Override
	public List<PaqueteVista> consultarVista() {
		return pd.consultarVista();
	}

	
	
}
