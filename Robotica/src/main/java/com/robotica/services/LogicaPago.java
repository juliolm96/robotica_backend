package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.PagoDAO;
import com.robotica.models.Pago;
import com.robotica.models.PagoVista;

@Service
public class LogicaPago implements PagoService{

	@Autowired
	PagoDAO pd;
	
	@Override
	public void crear(Pago p) {
		
		pd.crear(p);
	
	}

	@Override
	public void actualizar(Pago p) {
		
		pd.actualizar(p);
		
	}

	@Override
	public Pago buscar(int id) {

		return pd.buscar(id);
		
	}

	@Override
	public List<Pago> consultar() {

		return pd.consultar();
		
	}

	@Override
	public List<PagoVista> consultarVista() {
		return pd.consultarVista();
	}

	@Override
	public PagoVista buscarVista(int id) {
		return pd.buscarVista(id);
	}

}
