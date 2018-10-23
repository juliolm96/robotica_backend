package com.robotica.services;

import java.util.List;

import com.robotica.models.Socio;

public interface SocioService {

	public Socio crear(Socio miembro);
	public Socio buscar(int id);
	public List<Socio> consultar();
	public Socio actualizar(Socio miembro);
}
