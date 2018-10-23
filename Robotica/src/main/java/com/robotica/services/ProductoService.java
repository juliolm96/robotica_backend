package com.robotica.services;

import java.util.List;

import com.robotica.models.Producto;
import com.robotica.models.ProductoVista;


public interface ProductoService {

	public void insertar(Producto producto);
	public void actualizar(Producto producto);
	public ProductoVista buscar(int articuloId);
	public List<ProductoVista> consultar();
	
}
