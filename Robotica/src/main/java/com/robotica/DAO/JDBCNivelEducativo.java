package com.robotica.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.robotica.models.NivelEducativo;

@Repository
public class JDBCNivelEducativo implements NivelEducativoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void crear(NivelEducativo ne) throws DataAccessException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public NivelEducativo buscar(int id) throws DataAccessException{
		
		return null;
	}

	@Override
	public List<NivelEducativo> consultar() throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(NivelEducativo ne) throws DataAccessException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int buscarId(String descripcion) throws DataAccessException{
		int id = jdbcTemplate.queryForObject("SELECT id FROM NIVELES_EDUCATIVOS WHERE descripcion = ?",
				 Integer.class, descripcion);
		return id;
	}

}
