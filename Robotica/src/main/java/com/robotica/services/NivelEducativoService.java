package com.robotica.services;

import java.util.List;

import com.robotica.models.NivelEducativo;

public interface NivelEducativoService {

	public void crear(NivelEducativo ne);
	public NivelEducativo buscar(int id);
	public List<NivelEducativo> consultar();
	public void actualizar(NivelEducativo ne);
	public int buscarId(String descripcion);
}
