package com.robotica.services;

import java.util.List;

import com.robotica.models.NivelesEscuela;
import com.robotica.models.NivelesEscuelaVista;

public interface NivelesEscuelaService {

	public void crearNiveles(int idEscuela, String[] niveles);
	public void eliminarNiveles(int idEscuela, String[] niveles);
	public NivelesEscuelaVista buscar(int id);
	public List<NivelesEscuelaVista> consultar();
	public void actualizar(NivelesEscuela ne);	
	public List<NivelesEscuelaVista> consultarPorNivel(String nivel);	
	public List<String> consultarNivelesEscuelas(int id);
}
