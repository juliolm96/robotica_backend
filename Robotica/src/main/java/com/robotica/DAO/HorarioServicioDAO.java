package com.robotica.DAO;

import java.util.List;

import com.robotica.models.HorarioServicio;
import com.robotica.models.HorarioServicioVista;

public interface HorarioServicioDAO {
	
	public void crear(HorarioServicio hs);
	public List<HorarioServicioVista> consultar();
	public HorarioServicioVista buscar(int id);
	public void actualizar(HorarioServicio hs); 
	public void eliminar(int id);
	public List<HorarioServicioVista> consultarPorDia(String dia);
}	
