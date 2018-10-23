package com.robotica.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.robotica.models.Clase;

@Repository
public class JDBCClase implements ClaseDAO {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public void crear(Clase c) throws DataAccessException {
		
		if (c.getFecha() == null || c.getFecha().toString() == "" ) {
			jdbc.update(
					"INSERT INTO CLASES (fecha, hora_entrada, hora_salida, clases_tomadas, SOCIO_id) "
							+ "VALUES (NOW(),?,?,?,?)",
					c.getHora_entrada(), c.getHora_salida(), c.getClases_tomadas(), c.getSocioId());
		} else {
			jdbc.update(
					"INSERT INTO CLASES (fecha, hora_entrada, hora_salida, clases_tomadas, SOCIO_id) "
							+ "VALUES (?,?,?,?,?)",
					c.getFecha(), c.getHora_entrada(), c.getHora_salida(), c.getClases_tomadas(), c.getSocioId());
		}

	}

	@Override
	public void actualizar(Clase c) throws DataAccessException {
		jdbc.update("UPDATE clases");
	}

	@Override
	public Clase buscar(int id) throws DataAccessException {
		return jdbc.queryForObject("SELECT * FROM CLASES WHERE id = ?", new ClaseRM(), id);
	}

	@Override
	public List<Clase> consultar() throws DataAccessException {
		return jdbc.query("SELECT * FROM CLASES", new ClaseRM());
	}

	@Override
	public List<Clase> consultarClasesEnLaSemana(int socioId) {
		return jdbc.query("SELECT * FROM clases_semana_vista WHERE SOCIO_id = ?", new ClaseRM(), socioId);
	}

}
