package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.NivelEducativoDAO;
import com.robotica.DAO.NivelesEscuelaDAO;
import com.robotica.models.NivelesEscuela;
import com.robotica.models.NivelesEscuelaVista;

@Service
public class LogicaNivelesEscuela implements NivelesEscuelaService {

	@Autowired
	NivelesEscuelaDAO nEscuelaDAO;
	
	@Autowired
	NivelEducativoDAO nEducativoDAO;
	
	@Override
	public void crearNiveles(int idEscuela, String[] niveles) {
		int idNivel;
		for(int i = 0; i < niveles.length; i++) {
			NivelesEscuela ne = new NivelesEscuela();
			idNivel = nEducativoDAO.buscarId(niveles[i]);
			ne.setEscuelaId(idEscuela);
			ne.setNivelEducativoId(idNivel);
			nEscuelaDAO.crear(ne);	
		}		
	}

	@Override
	public NivelesEscuelaVista buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NivelesEscuelaVista> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(NivelesEscuela ne) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarNiveles(int idEscuela, String[] niveles) {
		int idNivel;
		int idNivelEscuela;
		for(int i = 0; i < niveles.length; i++) {
			idNivel = nEducativoDAO.buscarId(niveles[i]);
			idNivelEscuela = nEscuelaDAO.buscarId(idEscuela, idNivel);
			nEscuelaDAO.eliminar(idNivelEscuela);	
		}
	}

	@Override
	public List<NivelesEscuelaVista> consultarPorNivel(String nivel) {
		return nEscuelaDAO.consultarPorNivel(nivel);
	}

	@Override
	public List<String> consultarNivelesEscuelas(int id) {
		return nEscuelaDAO.consultarNivelesEscuelas(id);
	}

}
