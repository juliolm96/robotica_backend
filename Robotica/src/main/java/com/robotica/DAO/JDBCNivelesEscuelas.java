package com.robotica.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.robotica.models.NivelesEscuela;
import com.robotica.models.NivelesEscuelaVista;


@Repository
public class JDBCNivelesEscuelas implements NivelesEscuelaDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void crear(NivelesEscuela ne) throws DataAccessException {
		jdbcTemplate.update("INSERT INTO NIVELES_ESCUELAS (ESCUELA_id, NIVEL_EDUCATIVO_id) VALUES (?, ?)", 
				ne.getEscuelaId(), ne.getNivelEducativoId());		
	}

	@Override
	public NivelesEscuelaVista buscar(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NivelesEscuelaVista> consultar() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(NivelesEscuela ne) throws DataAccessException {
		// TODO Auto-generated method stub		
	}

	@Override
	public void eliminar(int id) {
		jdbcTemplate.update("DELETE FROM NIVELES_ESCUELAS WHERE id=?",id);		
	}

	@Override
	public List<NivelesEscuelaVista> consultarPorNivel(String nivel) throws DataAccessException {
		return jdbcTemplate.query("SELECT * FROM NIVELES_ESCUELAS_VISTA WHERE descripcion = ?", new NivelesEscuelaVistaRM(), nivel);
	}
	
	@Override
	public List<String> consultarNivelesEscuelas(int id) throws DataAccessException {
		List<String> data =  jdbcTemplate.queryForList("SELECT descripcion FROM NIVELES_ESCUELAS_VISTA WHERE id = ?", String.class, id);
		return data;
	}

	@Override
	public int buscarId(int idEscuela, int nivel) {
		int id = jdbcTemplate.queryForObject("SELECT id FROM NIVELES_ESCUELAS WHERE ESCUELA_id = ? AND NIVEL_EDUCATIVO_id = ?", Integer.class, idEscuela, nivel);
		return id;
	}

}
