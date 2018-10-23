package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.ClaseDAO;
import com.robotica.models.Clase;

@Service
public class LogicaClase implements ClaseService{

	@Autowired
	ClaseDAO cd;
	
	@Override
	public void crear(Clase c) {
		
		cd.crear(c);
	
	}

	@Override
	public void actualizar(Clase c) {
	
		cd.actualizar(c);
		
	}

	@Override
	public Clase buscar(int id) {
		
		return cd.buscar(id);
		
	}

	@Override
	public List<Clase> consultar() {

		return cd.consultar();
		
	}

	@Override
	public List<Clase> consultarUltimaSemana(int socioId) {
		return cd.consultarClasesEnLaSemana(socioId);
	}
	
}
