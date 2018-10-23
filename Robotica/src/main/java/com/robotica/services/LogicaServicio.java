package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robotica.DAO.ServicioDAO;
import com.robotica.models.Articulo;
import com.robotica.models.Servicio;
import com.robotica.models.ServicioVista;

@Service
@Transactional
public class LogicaServicio implements ServicioService {

	@Autowired
	ServicioDAO servicioDAO;
	
	@Autowired
	ArticuloService articuloService;

	
	@Override
	public void insertar(Servicio servicio) {
		
		Articulo articulo = new Articulo();
		articulo.setConcepto(servicio.getConcepto());
		articulo.setPrecio(servicio.getPrecio());
		int articuloId = articuloService.insertarServicio(articulo);
		
		servicioDAO.insertar(servicio, articuloId);
		
	}

	@Override
	public void actualizar(ServicioVista servicio) {
		
		servicioDAO.actualizar(servicio);
		
	}

	@Override
	public ServicioVista buscar(int id) {
		return servicioDAO.buscar(id);
	}

	@Override
	public List<ServicioVista> consultar() {
		return servicioDAO.consultar();
	}

}
