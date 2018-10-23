package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.SuscripcionDAO;
import com.robotica.models.Suscripcion;

@Service
public class LogicaSuscripcion implements SuscripcionService {

	@Autowired
	SuscripcionDAO suscripcionDAO;

	@Override
	public void crear(Suscripcion s) {

		suscripcionDAO.crear(s);

	}

	@Override
	public void actualizar(Suscripcion s) {

		suscripcionDAO.actualizar(s);

	}

	@Override
	public Suscripcion buscar(int id) {

		return suscripcionDAO.buscar(id);

	}

	@Override
	public List<Suscripcion> consultar() {

		return suscripcionDAO.consultar();

	}

}
