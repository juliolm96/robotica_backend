package com.robotica.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.robotica.models.Asignacion;
import com.robotica.models.AsignacionVista;

@Repository
public class JDBCAsignacion implements AsignacionDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void crear(Asignacion asignacion) throws DataAccessException{
		jdbcTemplate.update("INSERT INTO ASIGNACIONES (SOCIO_id, HORARIO_SERVICIO_id) VALUES (?, ?)",
				asignacion.getSocio_id(), asignacion.getHorario_servicio_id());
	}

	@Override
	public AsignacionVista buscar(int id) throws DataAccessException{
		AsignacionVista av = jdbcTemplate.queryForObject("SELECT * FROM ASIGNACIONES_VISTA WHERE id = ?",
				new AsignacionVistaRM(), id);
		return av;
	}
	
	@Override
	public List<AsignacionVista> consultarPorSocio(int numero) {
		List<AsignacionVista> av = jdbcTemplate.query("SELECT * FROM ASIGNACIONES_VISTA WHERE  numero_socio = ?",
				new AsignacionVistaRM(), numero);
		return av;
	}


	@Override
	public List<AsignacionVista> consultar() throws DataAccessException{
		List<AsignacionVista> av = jdbcTemplate.query("SELECT * FROM ASIGNACIONES_VISTA",
				new AsignacionVistaRM());
		return av;
	}

	@Override
	public void actualizar(Asignacion asignacion) throws DataAccessException{
		jdbcTemplate.update("UPDATE ASIGNACIONES SET SOCIO_id = ?, HORARIO_SERVICIO = ? WHERE id = ?",
				asignacion.getSocio_id(), asignacion.getHorario_servicio_id(), asignacion.getId());	
	}

	@Override
	public void eliminar(int id) {
		jdbcTemplate.update("DELETE FROM ASIGNACIONES WHERE id=?",id);		
	}

	
}
