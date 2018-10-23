package com.robotica.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.robotica.models.HorarioServicio;
import com.robotica.models.HorarioServicioVista;

@Repository
public class JDBCHorarioServicio implements HorarioServicioDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void crear(HorarioServicio hs) throws DataAccessException {
		jdbcTemplate.update("INSERT INTO HORARIOS_SERVICIO (dia, hora_inicial, hora_final, capacidad) VALUES (?, ?, ?, ?)",
				hs.getDia(), hs.getHora_inicial(), hs.getHora_final(), hs.getCapacidad());		
	}

	@Override
	public List<HorarioServicioVista> consultar() throws DataAccessException{
		List<HorarioServicioVista> hs = jdbcTemplate.query("SELECT * FROM HORARIOS_SERVICIO_VISTA",
				new HorarioServicioVistaRM());
		return hs;
	}

	@Override
	public HorarioServicioVista buscar(int id) throws DataAccessException{
		HorarioServicioVista hsv = jdbcTemplate.queryForObject("SELECT * FROM HORARIOS_SERVICIO_VISTA WHERE id = ?",
				new HorarioServicioVistaRM(), id);
		return hsv;
	}

	@Override
	public void actualizar(HorarioServicio hs)throws DataAccessException  {
		jdbcTemplate.update("UPDATE HORARIOS_SERVICIO SET dia = ?, hora_inicial = ?, hora_final = ?, capacidad = ? WHERE id = ?", 
				hs.getDia(), hs.getHora_inicial(), hs.getHora_final(), hs.getCapacidad(), hs.getId());		
	}

	@Override
	public void eliminar(int id) {
		jdbcTemplate.update("DELETE FROM HORARIOS_SERVICIO WHERE id=?",id);		
	}

	@Override
	public List<HorarioServicioVista> consultarPorDia(String dia) {
		List<HorarioServicioVista> hs = jdbcTemplate.query("SELECT * FROM HORARIOS_SERVICIO_VISTA WHERE dia = ?",
				new HorarioServicioVistaRM(), dia);
		return hs;
	}

}
