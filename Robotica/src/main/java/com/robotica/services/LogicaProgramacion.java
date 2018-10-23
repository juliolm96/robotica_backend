package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.ProgramacionDAO;
import com.robotica.models.Programacion;

@Service
public class LogicaProgramacion implements ProgramacionService {

	@Autowired
	ProgramacionDAO programacionDAO;
	
	@Override
	public void crear(Programacion programacion) {
		programacionDAO.crear(programacion);
	}

	@Override
	public Programacion buscar(int id) {
		return programacionDAO.buscar(id);
	}

	@Override
	public List<Programacion> consultar() {
		return programacionDAO.consultar();
	}

	@Override
	public void actualizar(Programacion programacion) {
		programacionDAO.actualizar(programacion);		
	}

}
