package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.SetDAO;
import com.robotica.models.Set;

@Service
public class LogicaSet implements SetService {

	@Autowired
	SetDAO setsDAO;

	@Override
	public void crear(Set s) {
		
		setsDAO.crear(s);
	
	}

	@Override
	public void actualizar(Set s) {
	
		setsDAO.actualizar(s);
	
	}

	@Override
	public Set buscar(int id) {
	
		return setsDAO.buscar(id);
	
	}

	@Override
	public List<Set> consultar() {
	
		return setsDAO.consultar();
	
	}

}
