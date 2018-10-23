package com.robotica.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.robotica.models.Set;

@Repository
public class JDBCSet implements SetDAO {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public void crear(Set s) throws DataAccessException {

		jdbc.update("INSERT INTO SETS (numero,descripcion,nombre) VALUES (?,?,?)", s.getNumero(), s.getDescripcion(),
				s.getNombre());

	}

	@Override
	public void actualizar(Set s) throws DataAccessException {

		jdbc.update("UPDATE SETS SET " + "numero = ?," + "nombre = ?," + "descripcion = ?" + "WHERE id = ?",
				s.getNumero(), s.getNombre(), s.getDescripcion(), s.getId());

	}

	@Override
	public Set buscar(int id) throws DataAccessException {

		return jdbc.queryForObject("SELECT * FROM SETS WHERE id = ?", new SetRM(), id);

	}

	@Override
	public List<Set> consultar() throws DataAccessException {

		return jdbc.query("SELECT * FROM SETS", new SetRM());

	}

}
