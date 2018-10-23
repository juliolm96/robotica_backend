package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.AsignacionDAO;
import com.robotica.models.Asignacion;
import com.robotica.models.AsignacionVista;

@Service
public class LogicaAsignacion implements AsignacionService {

	@Autowired
	AsignacionDAO asignacionDAO;
	
	@Override
	public void crear(Asignacion asignacion) {
		asignacionDAO.crear(asignacion);;		
	}

	@Override
	public AsignacionVista buscar(int id) {
		return asignacionDAO.buscar(id);
	}

	@Override
	public List<AsignacionVista> consultar() {
		return asignacionDAO.consultar();
	}

	@Override
	public void actualizar(Asignacion asignacion) {
		asignacionDAO.actualizar(asignacion);		
	}

	@Override
	public List<AsignacionVista>  consultarPorSocio(int numero) {
		return asignacionDAO.consultarPorSocio(numero);
	}

	@Override
	public void eliminar(int[] ids) {
		for(int i = 0; i < ids.length; i++) {
		asignacionDAO.eliminar(ids[i]);
		}
	}


}
