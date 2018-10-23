package com.robotica.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.robotica.models.Servicio;
import com.robotica.models.ServicioVista;

@Repository
public class JDBCServicio implements ServicioDAO {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public void insertar(Servicio servicio, int articuloId) throws DataAccessException {
		
		if(servicio.getPaqueteId() != 0) {
		jdbc.update("INSERT INTO SERVICIOS (dias, tipo, ARTICULO_id, PAQUETE_id) VALUES(?,?,?,?)", servicio.getDias(),
				servicio.getTipo(), articuloId, servicio.getPaqueteId());
		} else {
			jdbc.update("INSERT INTO SERVICIOS (dias, tipo, ARTICULO_id, PAQUETE_id) VALUES(?,?,?,?)", servicio.getDias(),
					servicio.getTipo(), articuloId, null);
		}

	}

	@Override
	public void actualizar(ServicioVista servicio) throws DataAccessException {
		
		jdbc.update("UPDATE SERVICIOS SET dias = ?, tipo = ?, PAQUETE_id = ? WHERE ARTICULO_id = ?", servicio.getDias(),
				servicio.getTipo(), servicio.getPaqueteId(), servicio.getArticuloId());

	}

	@Override
	public ServicioVista buscar(int articuloId) throws DataAccessException {
		return jdbc.queryForObject("SELECT * FROM servicios_vista WHERE articuloId = ?", new ServicioVistaRM(),
				articuloId);
	}

	@Override
	public List<ServicioVista> consultar() throws DataAccessException {
		return jdbc.query("SELECT * FROM servicios_vista", new ServicioVistaRM());
	}

}
