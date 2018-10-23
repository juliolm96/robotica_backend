package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.SocioDAO;
import com.robotica.models.Socio;

@Service
public class LogicaSocio implements SocioService {

	@Autowired
	SocioDAO socioDAO;
	
	@Override
	public Socio crear(Socio miembro) {
		int id = socioDAO.crear(miembro);
		return socioDAO.buscar(id);
	}

	@Override
	public Socio buscar(int id) {
		return socioDAO.buscar(id);
	}

	@Override
	public List<Socio> consultar() {
		return socioDAO.consultar();
	}

	@Override
	public Socio actualizar(Socio miembro) {
		return socioDAO.actualizar(miembro);
	}

}
