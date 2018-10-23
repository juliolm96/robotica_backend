package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robotica.DAO.ProductoDAO;
import com.robotica.models.Articulo;
import com.robotica.models.Producto;
import com.robotica.models.ProductoVista;

@Service
@Transactional
public class LogicaProducto implements ProductoService {

	@Autowired
	ArticuloService articuloService;
	
	@Autowired
	ProductoDAO productoDAO;

	@Override
	public void insertar(Producto producto) {
		
		Articulo articulo = new Articulo();
		articulo.setConcepto(producto.getConcepto());
		articulo.setPrecio(producto.getPrecio());
		int articuloId = articuloService.insertarProducto(articulo);
		
		productoDAO.insertar(producto, articuloId);
		
	}

	@Override
	public void actualizar(Producto producto) {
		
		Articulo articulo = new Articulo();
		articulo.setConcepto(producto.getConcepto());
		articulo.setPrecio(producto.getPrecio());
		articulo.setCodigo(producto.getCodigo());
		articulo.setId(producto.getArticuloId());
		articuloService.actualizar(articulo);
		
		productoDAO.actualizar(producto);
	}

	@Override
	public ProductoVista buscar(int id) {
		return productoDAO.buscar(id);
	}

	@Override
	public List<ProductoVista> consultar() {
		return productoDAO.consultar();
	}
	
	
	
}
