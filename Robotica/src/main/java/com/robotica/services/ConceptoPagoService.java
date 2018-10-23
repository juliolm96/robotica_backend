package com.robotica.services;

import java.util.List;

import com.robotica.models.ConceptoPago;

public interface ConceptoPagoService {

	public void crear(ConceptoPago cp);
	public void actualizar(ConceptoPago cp);
	public ConceptoPago buscar(int id);
	public List<ConceptoPago> consultar();

}
