package com.robotica.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.robotica.models.Socio;

@Repository
public class JDBCSocio implements SocioDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int crear(Socio miembro) throws DataAccessException {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);

		List<String> columnas = new ArrayList<>();

		columnas.add("fecha_ingreso");
		columnas.add("numero");
		columnas.add("nombre");
		columnas.add("apellido_paterno");
		columnas.add("apellido_materno");
		columnas.add("fecha_nacimiento");
		columnas.add("tutor");
		columnas.add("telefono");
		columnas.add("nivel_educativo");
		columnas.add("saldo_clases");
		columnas.add("ESCUELA_id");

		insert.setTableName("SOCIOS");
		insert.setColumnNames(columnas);

		Map<String, Object> datos = new HashMap<>();

		datos.put("fecha_ingreso", miembro.getFecha_ingreso());
		datos.put("numero", miembro.getNumero());
		datos.put("nombre", miembro.getNombre());
		datos.put("apellido_paterno", miembro.getApellido_paterno());
		datos.put("apellido_materno", miembro.getApellido_materno());
		datos.put("fecha_nacimiento", miembro.getFecha_nacimiento());
		datos.put("tutor", miembro.getTutor());
		datos.put("telefono", miembro.getTelefono());
		datos.put("nivel_educativo", miembro.getNivel_educativo());
		datos.put("saldo_clases", miembro.getSaldo_clases());
		datos.put("ESCUELA_id", miembro.getESCUELA_id());

		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(datos);

		return id.intValue();
	}

	@Override
	public Socio buscar(int id) throws DataAccessException {
		Socio miembro = jdbcTemplate.queryForObject("SELECT * FROM SOCIOS WHERE id = ?", new SocioRM(), id);
		return miembro;
	}

	@Override
	public List<Socio> consultar() throws DataAccessException {
		List<Socio> miembros = jdbcTemplate.query("SELECT * FROM SOCIOS", new SocioRM());
		return miembros;
	}

	@Override
	public Socio actualizar(Socio miembro) throws DataAccessException {
		jdbcTemplate.update(
				"UPDATE SOCIOS SET nombre = ?, apellido_paterno = ?, apellido_materno = ?, "
						+ "fecha_nacimiento = ?, tutor = ?, telefono = ?, nivel_educativo = ?, saldo_clases = ?, ESCUELA_id = ?   WHERE id = ?",
				miembro.getNombre(), miembro.getApellido_paterno(), miembro.getApellido_materno(),
				miembro.getFecha_nacimiento(), miembro.getTutor(), miembro.getTelefono(), miembro.getNivel_educativo(),
				miembro.getSaldo_clases(), miembro.getESCUELA_id(), miembro.getId());
		return miembro;
	}

}
