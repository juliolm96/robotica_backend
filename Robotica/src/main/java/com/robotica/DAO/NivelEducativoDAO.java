package com.robotica.DAO;

import java.util.List;

import com.robotica.models.NivelEducativo;

public interface NivelEducativoDAO {

	public void crear(NivelEducativo ne);
	public NivelEducativo buscar(int id);
	public List<NivelEducativo> consultar();
	public void actualizar(NivelEducativo ne);
	public int buscarId(String descripcion);
	
}
