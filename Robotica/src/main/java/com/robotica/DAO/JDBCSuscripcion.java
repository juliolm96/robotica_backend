package com.robotica.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.robotica.models.Suscripcion;

@Repository
public class JDBCSuscripcion implements SuscripcionDAO{

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public void crear(Suscripcion s) throws DataAccessException{
		
		jdbc.update("INSERT INTO SUSCRIPCIONES (MIEMBRO_id, PAQUETE_id) VALUES (?,?)",
					s.getMiembroId(),s.getPaqueteId());
		
	}

	@Override
	public void actualizar(Suscripcion s) throws DataAccessException{
		
		jdbc.update("UPDATE SUSCRIPCIONES SET"
				+ "MIEMBRO_id = ?,"
				+ "PAQUETE_id = ?"
				+ "WHERE id = ?",
				s.getMiembroId(),
				s.getPaqueteId(),
				s.getId());
		
	}

	@Override
	public Suscripcion buscar(int id) throws DataAccessException{
		
		return jdbc.queryForObject("SELECT * FROM SUSCRIPCIONES WHERE id = ?", new SuscripcionRM(), id);
		
	}

	@Override
	public List<Suscripcion> consultar() throws DataAccessException {
		
		return jdbc.query("SELECT * FROM SUSCRIPCONES", new SuscripcionRM());
		
	}

}

