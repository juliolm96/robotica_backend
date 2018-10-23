package com.robotica.DAO;

import java.util.List;

import com.robotica.models.Articulo;

public interface ArticuloDAO {

	public int insertar(Articulo articulo);
	public void actualizar(Articulo articulo);
	public Articulo buscar(int id);
	public List<Articulo> consultar();
	public String getUltimoProducto();
	public String getUltimoServicio();
}
