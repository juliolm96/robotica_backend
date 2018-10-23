package com.robotica.DAO;

import java.util.List;

import com.robotica.models.Construccion;


public interface ConstruccionDAO {
	
	public void crear(Construccion c);
	public Construccion buscar(int id);
	public List<Construccion> consultar();
	public void actualizar(Construccion c);
	public int getNumeroPasos(int modeloId);
	public Construccion getPrimero(int modeloId);
	public Construccion getSiguiente(int modeloId, int numeroActual);

}
