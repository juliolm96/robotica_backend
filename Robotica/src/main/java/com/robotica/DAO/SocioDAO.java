package com.robotica.DAO;

import java.util.List;

import com.robotica.models.Socio;

public interface SocioDAO {

	public int crear(Socio miembro);
	public Socio buscar(int id);
	public List<Socio> consultar();
	public Socio actualizar(Socio miembro);
	
}
