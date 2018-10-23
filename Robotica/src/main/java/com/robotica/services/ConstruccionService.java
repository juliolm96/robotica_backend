package com.robotica.services;

import java.util.List;

import com.robotica.models.Construccion;

public interface ConstruccionService {

	public void crear(Construccion construccion);
	public Construccion buscar(int id);
	public List<Construccion> consultar();
	public void actualizar(Construccion construccion);
	public int getNumeroPasos(int modeloId);
	public Construccion getPrimero(int modeloId);
	public Construccion getSiguiente(int modeloId, int numeroActual);
}
