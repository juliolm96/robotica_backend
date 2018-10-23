package com.robotica.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.robotica.models.Escuela;

@Repository
public class JDBCEscuela implements EscuelaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void crear(Escuela escuela) throws DataAccessException{
		jdbcTemplate.update("INSERT INTO ESCUELAS (clave, nombre) VALUES (?, ?)", 
				escuela.getClave(), escuela.getNombre());
	}

	@Override
	public Escuela buscar(int id) throws DataAccessException{
		Escuela escuela = jdbcTemplate.queryForObject("SELECT * FROM  ESCUELAS WHERE id = ?",
				new EscuelaRM(), id);
		return escuela;
	}

	@Override
	public List<Escuela> consultar() throws DataAccessException{
		List<Escuela> escuela = jdbcTemplate.query("SELECT * FROM ESCUELAS", new EscuelaRM());
		return escuela;
	}

	@Override
	public void actualizar(Escuela escuela)throws DataAccessException {
		jdbcTemplate.update("UPDATE ESCUELAS SET clave = ?, nombre = ? WHERE id = ?",
				escuela.getClave(), escuela.getNombre(), escuela.getId());

	}
	

}
