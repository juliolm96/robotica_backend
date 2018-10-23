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

import com.robotica.models.Programacion;

@Repository
public class JDBCProgramacion implements ProgramacionDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void crear(Programacion p) throws DataAccessException {

		String b64 = p.getInstruccion().split(",")[1];
		byte[] decoded = Base64.decodeBase64(b64.getBytes());
		InputStream inputStream = new ByteArrayInputStream(decoded);

		LobHandler lobHandler = new DefaultLobHandler();
		jdbcTemplate.execute("INSERT INTO PROGRAMACION (instruccion, numero, MODELO_id) " + "VALUES (?,?,?)",
				new AbstractLobCreatingPreparedStatementCallback(lobHandler) {

					@Override
					protected void setValues(PreparedStatement ps, LobCreator lc)
							throws SQLException, DataAccessException {
						ps.setString(1, p.getInstruccion());
						lc.setBlobAsBinaryStream(ps, 2, inputStream, decoded.length);
						ps.setInt(3, p.getModelo_id());

					}
				});

	}

	@Override
	public List<Programacion> consultar() throws DataAccessException {
		List<Programacion> programacion = jdbcTemplate.query("SELECT * FROM PROGRAMACION", new ProgramacionRM());
		return programacion;
	}

	@Override
	public Programacion buscar(int id) throws DataAccessException {
		Programacion programacion = jdbcTemplate.queryForObject("SELECT * FROM PROGRAMACION WHERE id = ?",
				new ProgramacionRM(), id);
		return programacion;
	}

	@Override
	public void actualizar(Programacion p) throws DataAccessException {

		String b64 = p.getInstruccion().split(",")[1];
		byte[] decoded = Base64.decodeBase64(b64.getBytes());
		InputStream inputStream = new ByteArrayInputStream(decoded);

		LobHandler lobHandler = new DefaultLobHandler();
		jdbcTemplate.execute(
				"UPDATE PROGRAMACION SET " + "instruccion = ?, " + "numero = ?, " + "MODELO_id = ?" + "WHERE id = ? ",
				new AbstractLobCreatingPreparedStatementCallback(lobHandler) {

					@Override
					protected void setValues(PreparedStatement ps, LobCreator lc)
							throws SQLException, DataAccessException {
						ps.setString(1, p.getInstruccion());
						lc.setBlobAsBinaryStream(ps, 2, inputStream, decoded.length);
						ps.setInt(3, p.getModelo_id());
						ps.setInt(4, p.getId());

					}
				});

	}

}
