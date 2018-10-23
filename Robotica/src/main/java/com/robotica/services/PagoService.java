package com.robotica.services;

import java.util.List;

import com.robotica.models.Pago;
import com.robotica.models.PagoVista;


public interface PagoService {
	
	public void crear(Pago p);
	public void actualizar(Pago p);
	public Pago buscar(int id);
	public List<Pago> consultar();
	public List<PagoVista> consultarVista();
	public PagoVista buscarVista(int id);
	
}
