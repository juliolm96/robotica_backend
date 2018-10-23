package com.robotica.DAO;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.robotica.models.Clase_Modelo;
import com.robotica.models.Modelo;
import com.robotica.models.ModeloVista;

@Repository
public class JDBCModelo implements ModeloDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void crear(Modelo modelo) throws DataAccessException {

		String b64 = modelo.getImagen().split(",")[1];
		byte[] decoded = Base64.decodeBase64(b64.getBytes());
		InputStream inputStream = new ByteArrayInputStream(decoded);

		LobHandler lobHandler = new DefaultLobHandler();
		jdbcTemplate.execute(
				"" + "INSERT INTO MODELOS (nombre, descripcion, imagen, PAQUETE_id) " + "VALUES (?,?,?,?)",
				new AbstractLobCreatingPreparedStatementCallback(lobHandler) {

					@Override
					protected void setValues(PreparedStatement ps, LobCreator lc)
							throws SQLException, DataAccessException {
						ps.setString(1, modelo.getNombre());
						ps.setString(2, modelo.getDescripcion());
						lc.setBlobAsBinaryStream(ps, 3, inputStream, decoded.length);
						ps.setInt(4, modelo.getPaquete_id());

					}
				});
	}

	@Override
	public Modelo buscar(int id) throws DataAccessException {
		Modelo modelo = jdbcTemplate.queryForObject("SELECT * FROM MODELOS WHERE id = ?", new ModeloRM(), id);
		return modelo;
	}

	@Override
	public List<Modelo> consultar() throws DataAccessException {
		List<Modelo> modelos = jdbcTemplate.query("SELECT * FROM MODELOS", new ModeloRM());
		return modelos;
	}

	@Override
	public void actualizar(Modelo modelo) throws DataAccessException {

		String b64 = modelo.getImagen().split(",")[1];
		byte[] decoded = Base64.decodeBase64(b64.getBytes());
		InputStream inputStream = new ByteArrayInputStream(decoded);

		LobHandler lobHandler = new DefaultLobHandler();
		jdbcTemplate.execute(
				"" + "UPDATE MODELOS SET "
						+ "nombre = ?, "
						+ "descripcion = ?, "
						+ "imagen = ?, "
						+ "PAQUETE_id = ? "
						+ "WHERE id = ?",
				new AbstractLobCreatingPreparedStatementCallback(lobHandler) {

					@Override
					protected void setValues(PreparedStatement ps, LobCreator lc)
							throws SQLException, DataAccessException {
						ps.setString(1, modelo.getNombre());
						ps.setString(2, modelo.getDescripcion());
						lc.setBlobAsBinaryStream(ps, 3, inputStream, decoded.length);
						ps.setInt(4, modelo.getPaquete_id());
						ps.setInt(5, modelo.getId());

					}
				});
	}

	@Override
	public ModeloVista buscarVista(int id) throws DataAccessException {	
		return jdbcTemplate.queryForObject("SELECT * FROM modelos_vista WHERE id = ?", new ModeloVistaRM(), id);
	}

	@Override
	public List<ModeloVista> consultarVistas() throws DataAccessException {
		return jdbcTemplate.query("SELECT * FROM modelos_vista", new ModeloVistaRM());
	}

	@Override
	public List<ModeloVista> consultarModelosPorPaquete(int paqueteId) {
		return jdbcTemplate.query("SELECT * FROM modelos_vista WHERE PAQUETE_id = ?", new ModeloVistaRM(), paqueteId);
	}

	@Override
	public List<Clase_Modelo> consultarModelosHechosPorSocio(int socioId) {
		return jdbcTemplate.query("SELECT MODELOS.`id`, "
				+ "MODELOS.`descripcion`, "
				+ "MODELOS.`imagen`, "
				+ "MODELOS.`nombre`, "
				+ "MODELOS.`PAQUETE_id`, "
				+ "CLASES.`id` AS claseId, "
				+ "CLASES.`alcance`,"
				+ "(SELECT PAQUETES.`nombre` FROM PAQUETES WHERE PAQUETES.`id` = MODELOS.`PAQUETE_id`) AS nombre_paquete "
				+ "FROM MODELOS "
				+ "JOIN CLASES ON clases.`MODELO_id` = modelos.`id` "
				+ "WHERE CLASES.`SOCIO_id` = ?", new Clase_ModeloRM(), socioId);
	}
	

}
