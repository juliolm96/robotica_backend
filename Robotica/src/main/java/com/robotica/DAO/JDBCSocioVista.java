package com.robotica.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.robotica.models.SocioVista;

@Repository
public class JDBCSocioVista implements SocioVistaDAO {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<SocioVista> consultar() throws DataAccessException {
		return jdbc.query("SELECT * FROM SOCIOS_VISTA", new SocioVistaRM());
	}

	@Override
	public SocioVista buscar(int id) throws DataAccessException {
		return jdbc.queryForObject("SELECT * FROM SOCIOS_VISTA WHERE id = ?", new SocioVistaRM(), id);
	}

	@Override
	public SocioVista buscarPorNumero(int numero) throws DataAccessException {
		return jdbc.queryForObject("SELECT * FROM SOCIOS_VISTA WHERE numero = ?", new SocioVistaRM(), numero);
	}

	@Override
	public List<SocioVista> buscarPorNombre(String nombre) throws DataAccessException {
		return jdbc.query("SELECT * FROM socios_vista WHERE nombre like '" + nombre + "%'", new SocioVistaRM());
	}

}
