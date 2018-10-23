package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.EscuelaDAO;
import com.robotica.models.Escuela;

@Service
public class LogicaEscuela implements EscuelaService {

	@Autowired
	EscuelaDAO escuelaDAO;

	@Override
	public void crear(Escuela escuela) {
		escuelaDAO.crear(escuela);
	}

	@Override
	public Escuela buscar(int id) {
		return escuelaDAO.buscar(id);
	}

	@Override
	public List<Escuela> consultar() {
		return escuelaDAO.consultar();
	}

	@Override
	public void actualizar(Escuela escuela) {
		escuelaDAO.actualizar(escuela);		
	}
	

}
