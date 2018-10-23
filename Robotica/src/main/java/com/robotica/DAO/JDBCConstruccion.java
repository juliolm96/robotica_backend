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

import com.robotica.models.Construccion;

@Repository
public class JDBCConstruccion implements ConstruccionDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void crear(Construccion c) throws DataAccessException {

		String b64 = c.getMaterial().split(",")[1];
		byte[] decoded1 = Base64.decodeBase64(b64.getBytes());
		InputStream inputStream1 = new ByteArrayInputStream(decoded1);

		b64 = c.getInstruccion().split(",")[1];
		byte[] decoded2 = Base64.decodeBase64(b64.getBytes());
		InputStream inputStream2 = new ByteArrayInputStream(decoded2);

		b64 = c.getEnsamblado().split(",")[1];
		byte[] decoded3 = Base64.decodeBase64(b64.getBytes());
		InputStream inputStream3 = new ByteArrayInputStream(decoded3);

		LobHandler lobHandler = new DefaultLobHandler();
		jdbcTemplate.execute("" + "INSERT INTO CONSTRUCCION (material, instruccion, ensamblado, numero, MODELO_id) "
				+ "VALUES (?,?,?,?,?)", new AbstractLobCreatingPreparedStatementCallback(lobHandler) {

					@Override
					protected void setValues(PreparedStatement ps, LobCreator lc)
							throws SQLException, DataAccessException {
						lc.setBlobAsBinaryStream(ps, 1, inputStream1, decoded1.length);
						lc.setBlobAsBinaryStream(ps, 2, inputStream2, decoded2.length);
						lc.setBlobAsBinaryStream(ps, 3, inputStream3, decoded3.length);
						ps.setInt(4, c.getNumero());
						ps.setInt(5, c.getModeloId());

					}
				});

	}

	@Override
	public Construccion buscar(int id) throws DataAccessException {
		Construccion construccion = jdbcTemplate.queryForObject("SELECT * FROM CONSTRUCCION WHERE id = ?",
				new ConstruccionRM(), id);
		return construccion;
	}

	@Override
	public List<Construccion> consultar() throws DataAccessException {
		List<Construccion> construccion = jdbcTemplate.query("SELECT * FROM CONSTRUCCION", new ConstruccionRM());
		return construccion;
	}

	@Override
	public void actualizar(Construccion c) throws DataAccessException {


		String b64 = c.getMaterial().split(",")[1];
		byte[] decoded1 = Base64.decodeBase64(b64.getBytes());
		InputStream inputStream1 = new ByteArrayInputStream(decoded1);

		b64 = c.getInstruccion().split(",")[1];
		byte[] decoded2 = Base64.decodeBase64(b64.getBytes());
		InputStream inputStream2 = new ByteArrayInputStream(decoded2);

		b64 = c.getEnsamblado().split(",")[1];
		byte[] decoded3 = Base64.decodeBase64(b64.getBytes());
		InputStream inputStream3 = new ByteArrayInputStream(decoded3);

		LobHandler lobHandler = new DefaultLobHandler();
		jdbcTemplate.execute("" + "UPDATE CONSTRUCCION SET "
				+ "material = ?,"
				+ "instruccion = ?, "
				+ "ensamblado = ?, "
				+ "numero = ?, "
				+ "MODELO_id = ? "
				+ "WHERE id = ?", new AbstractLobCreatingPreparedStatementCallback(lobHandler) {

					@Override
					protected void setValues(PreparedStatement ps, LobCreator lc)
							throws SQLException, DataAccessException {
						lc.setBlobAsBinaryStream(ps, 1, inputStream1, decoded1.length);
						lc.setBlobAsBinaryStream(ps, 2, inputStream2, decoded2.length);
						lc.setBlobAsBinaryStream(ps, 3, inputStream3, decoded3.length);
						ps.setInt(4, c.getNumero());
						ps.setInt(5, c.getModeloId());
						ps.setInt(6, c.getId());

					}
				});
		
	}

	@Override
	public int getNumeroPasos(int modeloId) throws DataAccessException {
		return jdbcTemplate.queryForObject(""
				+ "SELECT MAX(numero) AS total_pasos "
				+ "FROM construccion "
				+ "WHERE MODELO_id = ?", Integer.class, modeloId);
	}

	@Override
	public Construccion getPrimero(int modeloId) throws DataAccessException {
		return jdbcTemplate.queryForObject("SELECT * FROM construccion "
				+ "WHERE MODELO_id = ? AND "
				+ "numero = 1", new ConstruccionRM(), modeloId);
	}

	@Override
	public Construccion getSiguiente(int modeloId, int numeroActual) throws DataAccessException {
		return jdbcTemplate.queryForObject("SELECT * FROM construccion "
				+ "WHERE MODELO_id = ? AND "
				+ "numero = ? + 1", new ConstruccionRM(), modeloId, numeroActual);
	}

}
