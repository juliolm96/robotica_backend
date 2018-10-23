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

import com.robotica.models.Articulo;

@Repository
public class JDBCArticulo implements ArticuloDAO {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int insertar(Articulo articulo) throws DataAccessException {

		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);
		
		List<String> columns = new ArrayList<>();
		
		columns.add("concepto");
		columns.add("precio");
		columns.add("codigo");
		
		insert.setTableName("ARTICULOS");
		insert.setColumnNames(columns);
		
		Map<String, Object> data = new HashMap<>();
		
		data.put("concepto", articulo.getConcepto());
		data.put("precio", articulo.getPrecio());
		data.put("codigo", articulo.getCodigo());
		
		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(data);
		
		return id.intValue();

	}

	@Override
	public void actualizar(Articulo articulo) throws DataAccessException {
		jdbc.update("UPDATE ARTICULOS SET " + "concepto = ? ," + "precio = ? , " + "codigo = ? " + "WHERE id = ? ",
				articulo.getConcepto(), articulo.getPrecio(), articulo.getCodigo(), articulo.getId());
	}

	@Override
	public Articulo buscar(int id) throws DataAccessException {
		return jdbc.queryForObject("SELECT * FROM ARTICULOS WHERE id = ?", new ArticuloRM(), id);
	}

	@Override
	public List<Articulo> consultar() throws DataAccessException {
		return jdbc.query("SELECT * FROM ARTICULOS", new ArticuloRM());
	}

	@Override
	public String getUltimoProducto() throws DataAccessException {

		return jdbc.queryForObject("SELECT codigo FROM articulos WHERE SUBSTRING(codigo,1,1) = 'P' ORDER BY codigo DESC LIMIT 1;", String.class);

	}

	@Override
	public String getUltimoServicio() throws DataAccessException {

		return jdbc.queryForObject("SELECT codigo FROM articulos WHERE SUBSTRING(codigo,1,1) = 'S' ORDER BY codigo DESC LIMIT 1;", String.class);

	}

}
