package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.ConstruccionDAO;
import com.robotica.models.Construccion;

@Service
public class LogicaConstruccion implements ConstruccionService {

	@Autowired
	ConstruccionDAO construccionDAO;
	
	@Override
	public void crear(Construccion construccion) {
		construccionDAO.crear(construccion);
	}

	@Override
	public Construccion buscar(int id) {
		return construccionDAO.buscar(id);
	}

	@Override
	public List<Construccion> consultar() {
		return construccionDAO.consultar();
	}

	@Override
	public void actualizar(Construccion construccion) {
		construccionDAO.actualizar(construccion);		
	}

	@Override
	public int getNumeroPasos(int modeloId) {
		return construccionDAO.getNumeroPasos(modeloId);
	}

	@Override
	public Construccion getPrimero(int modeloId) {
		return construccionDAO.getPrimero(modeloId);
	}

	@Override
	public Construccion getSiguiente(int modeloId, int numeroActual) {
		return construccionDAO.getSiguiente(modeloId, numeroActual);
	}

}
