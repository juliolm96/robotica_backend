package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.SocioVistaDAO;
import com.robotica.models.SocioVista;

@Service
public class LogicaSocioVista implements SocioVistaService{
	
	@Autowired
	SocioVistaDAO svd;

	@Override
	public List<SocioVista> consultar() {
		return svd.consultar();
	}

	@Override
	public SocioVista buscar(int id) {
		return svd.buscar(id);
	}

	@Override
	public SocioVista buscarPorNumero(int numero) {
		return svd.buscarPorNumero(numero);
	}

	@Override
	public List<SocioVista> buscarPorNombre(String nombre) {
		return svd.buscarPorNombre(nombre);
	}

	
	
}
