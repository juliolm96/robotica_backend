package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.NivelEducativoDAO;
import com.robotica.models.NivelEducativo;

@Service
public class LogicaNivelEducativo implements NivelEducativoService {

	@Autowired
	NivelEducativoDAO neDAO;
	
	@Override
	public void crear(NivelEducativo ne) {
		// TODO Auto-generated method stub

	}

	@Override
	public NivelEducativo buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NivelEducativo> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(NivelEducativo ne) {
		// TODO Auto-generated method stub

	}

	@Override
	public int buscarId(String descripcion) {
		return neDAO.buscarId(descripcion);
	}

}
