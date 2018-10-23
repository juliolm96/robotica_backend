package com.robotica.services;

import java.util.List;

import com.robotica.models.HorarioServicio;
import com.robotica.models.HorarioServicioVista;

public interface HorarioServicioService {
	
	public void crear(HorarioServicio hs);
	public List<HorarioServicioVista> consultar();
	public HorarioServicioVista buscar(int id);
	public void actualizar(HorarioServicio hs);
	public void eliminarHorarios(int[] ids);
	public List<HorarioServicioVista> consultarPorDia(String dia);
	
}
