package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.ConceptoPagoDAO;
import com.robotica.models.ConceptoPago;

@Service
public class LogicaConceptoPago implements ConceptoPagoService{

	@Autowired
	ConceptoPagoDAO cpd;
	
	@Override
	public void crear(ConceptoPago cp) {
	
		cpd.crear(cp);
	
	}

	@Override
	public void actualizar(ConceptoPago cp) {
		
		cpd.actualizar(cp);
		
	}

	@Override
	public ConceptoPago buscar(int id) {
		
		return cpd.buscar(id);
	
	}

	@Override
	public List<ConceptoPago> consultar() {
	
		return cpd.consultar();
	
	}
	
	

}
