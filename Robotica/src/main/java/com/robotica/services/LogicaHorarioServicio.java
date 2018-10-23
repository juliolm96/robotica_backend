package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.HorarioServicioDAO;
import com.robotica.models.HorarioServicio;
import com.robotica.models.HorarioServicioVista;


@Service
public class LogicaHorarioServicio implements HorarioServicioService {

	@Autowired
	HorarioServicioDAO HorarioServicioDAO;
	
	@Override
	public void crear(HorarioServicio hs) {
		HorarioServicioDAO.crear(hs);		
	}

	@Override
	public List<HorarioServicioVista> consultar() {
		return HorarioServicioDAO.consultar();
	}

	@Override
	public HorarioServicioVista buscar(int id) {
		return HorarioServicioDAO.buscar(id);
	}

	@Override
	public void actualizar(HorarioServicio hs) {
		HorarioServicioDAO.actualizar(hs);		
	}

	@Override
	public void eliminarHorarios(int[] ids) {
		for(int i = 0; i < ids.length; i++) {
			HorarioServicioDAO.eliminar(ids[i]);	
		}
	}

	@Override
	public List<HorarioServicioVista> consultarPorDia(String dia) {
		return HorarioServicioDAO.consultarPorDia(dia);
	}

}
