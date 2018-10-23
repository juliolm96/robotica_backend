package com.robotica.services;

import java.util.List;

import com.robotica.models.Articulo;

public interface ArticuloService {

	public int insertarProducto(Articulo articulo);
	public int insertarServicio(Articulo articulo);
	public void actualizar(Articulo articulo);
	public List<Articulo> consultar();
	public Articulo buscar(int id);
	
}
