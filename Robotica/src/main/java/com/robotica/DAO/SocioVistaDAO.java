package com.robotica.DAO;

import java.util.List;

import com.robotica.models.SocioVista;

public interface SocioVistaDAO {

	public List<SocioVista> consultar();

	public SocioVista buscar(int id);
	
	public SocioVista buscarPorNumero(int numero);
	
	public List<SocioVista> buscarPorNombre(String nombre);
	
}
