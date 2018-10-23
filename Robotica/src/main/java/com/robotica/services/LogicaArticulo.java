package com.robotica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotica.DAO.ArticuloDAO;
import com.robotica.models.Articulo;

@Service
public class LogicaArticulo implements ArticuloService {

	@Autowired
	ArticuloDAO articuloDAO;
	
	@Override
	public int insertarProducto(Articulo articulo) {
		
		String ultimoProducto;
		try {
			ultimoProducto = articuloDAO.getUltimoProducto();
		} catch(Exception e) {
			ultimoProducto = "P0000";
		}
		
		int totalProductos = Integer.parseInt(ultimoProducto.substring(1));
		
		if (totalProductos == 0) {
			articulo.setCodigo("P0001");
		} else if (totalProductos < 9 && totalProductos > 0) {
			articulo.setCodigo("P000" + (totalProductos + 1));
		} else if (totalProductos >= 9 && totalProductos < 99) {
			articulo.setCodigo("P00" + (totalProductos + 1));
		} else if (totalProductos >= 99 && totalProductos < 999) {
			articulo.setCodigo("P0" + (totalProductos + 1));
		} else if (totalProductos >= 999 && totalProductos < 9998) {
			articulo.setCodigo("P" + (totalProductos + 1));
		}
		
		return articuloDAO.insertar(articulo);
	}

	@Override
	public int insertarServicio(Articulo articulo) {
		
		String ultimoServicio;
		try {
			ultimoServicio = articuloDAO.getUltimoServicio();
		} catch(Exception e) {
			e.printStackTrace();
			ultimoServicio = "S0000";
		}
		
		int totalServicios = Integer.parseInt(ultimoServicio.substring(1));
		if (totalServicios == 0) {
			articulo.setCodigo("S0001");
		} else if (totalServicios < 9 && totalServicios > 0) {
			articulo.setCodigo("S000" + (totalServicios + 1));
		} else if (totalServicios >= 9 && totalServicios < 99) {
			articulo.setCodigo("S00" + (totalServicios + 1));
		} else if (totalServicios >= 99 && totalServicios < 999) {
			articulo.setCodigo("S0" + (totalServicios + 1));
		} else if (totalServicios >= 999 && totalServicios < 9998) {
			articulo.setCodigo("S" + (totalServicios + 1));
		}
		
		return articuloDAO.insertar(articulo);
		
	}

	@Override
	public void actualizar(Articulo articulo) {
		articuloDAO.actualizar(articulo);
	}

	@Override
	public List<Articulo> consultar() {
		return articuloDAO.consultar();
	}

	@Override
	public Articulo buscar(int id) {
		return articuloDAO.buscar(id);
	}

}
