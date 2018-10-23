package com.robotica.DAO;

import java.util.List;

import com.robotica.models.Producto;
import com.robotica.models.ProductoVista;

public interface ProductoDAO {

	public void insertar(Producto producto, int articuloId);

	public void actualizar(Producto producto);

	public ProductoVista buscar(int articuloId);

	public List<ProductoVista> consultar();

}
