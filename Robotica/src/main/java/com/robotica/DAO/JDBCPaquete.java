package com.robotica.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.robotica.models.Paquete;
import com.robotica.models.PaqueteVista;

@Repository
public class JDBCPaquete implements PaqueteDAO {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public void crear(Paquete p) throws DataAccessException {

		jdbc.update("INSERT INTO PAQUETES (nombre,descripcion,SET_id) VALUES (?,?,?) ", p.getNombre(),
				p.getDescripcion(), p.getSetId());

	}

	@Override
	public void actualizar(Paquete p) throws DataAccessException {

		jdbc.update("UPDATE PAQUETES SET " + "nombre = ?, " + "descripcion = ?, " + "SET_id = ? " + "WHERE id = ?",
				p.getNombre(), p.getDescripcion(), p.getSetId(), p.getId());

	}

	@Override
	public Paquete buscar(int id) throws DataAccessException {

		return jdbc.queryForObject("SELECT * FROM PAQUETES WHERE id = ?", new PaqueteRM(), id);

	}

	@Override
	public List<Paquete> consultar() throws DataAccessException {

		return jdbc.query("SELECT * FROM PAQUETES", new PaqueteRM());

	}

	@Override
	public PaqueteVista buscarVista(int id) throws DataAccessException {

		return jdbc.queryForObject("SELECT * FROM PAQUETES_VISTA WHERE id = ?", new PaqueteVistaRM(), id);

	}

	@Override
	public List<PaqueteVista> consultarVista() throws DataAccessException {
		return jdbc.query("SELECT * FROM PAQUETES_VISTA", new PaqueteVistaRM());
	}

}
