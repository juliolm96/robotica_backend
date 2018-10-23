package com.robotica.DAO;

import java.util.List;

import com.robotica.models.NivelesEscuela;
import com.robotica.models.NivelesEscuelaVista;

public interface NivelesEscuelaDAO {
	public void crear(NivelesEscuela ne);
	public NivelesEscuelaVista buscar(int id);
	public List<NivelesEscuelaVista> consultar();
	public void actualizar(NivelesEscuela ne);	
	public void eliminar(int id);
	public List<NivelesEscuelaVista> consultarPorNivel(String nivel);
	public List<String> consultarNivelesEscuelas(int id);
	public int buscarId(int idEscuela, int nivel);
}
