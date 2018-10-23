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

import com.robotica.models.Producto;
import com.robotica.models.ProductoVista;

@Repository
public class JDBCProducto implements ProductoDAO {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public void insertar(Producto producto, int articuloId) throws DataAccessException {

		String b64 = producto.getImagen().split(",")[1];
		byte[] decoded1 = Base64.decodeBase64(b64.getBytes());
		InputStream inputStream1 = new ByteArrayInputStream(decoded1);
		
		LobHandler lobHandler = new DefaultLobHandler();
		jdbc.execute("" + "INSERT INTO PRODUCTOS (existencias, imagen, ARTICULO_id) VALUES (?,?,?)", 
				new AbstractLobCreatingPreparedStatementCallback(lobHandler) {

					@Override
					protected void setValues(PreparedStatement ps, LobCreator lc)
							throws SQLException, DataAccessException {
						ps.setInt(1, producto.getExistencias());
						lc.setBlobAsBinaryStream(ps, 2, inputStream1, decoded1.length);
						ps.setInt(3, articuloId);

					}
				});

	}

	@Override
	public void actualizar(Producto producto) throws DataAccessException {
		System.out.println(producto);
		
		String b64 = producto.getImagen().split(",")[1];
		byte[] decoded1 = Base64.decodeBase64(b64.getBytes());
		InputStream inputStream1 = new ByteArrayInputStream(decoded1);
		
		LobHandler lobHandler = new DefaultLobHandler();
		jdbc.execute("UPDATE PRODUCTOS SET existencias = ?, imagen = ? WHERE id = ?", 
				new AbstractLobCreatingPreparedStatementCallback(lobHandler) {

					@Override
					protected void setValues(PreparedStatement ps, LobCreator lc)
							throws SQLException, DataAccessException {
						ps.setInt(1, producto.getExistencias());
						lc.setBlobAsBinaryStream(ps, 2, inputStream1, decoded1.length);
						ps.setInt(3, producto.getProductoId());

					}
				});

	}

	@Override
	public ProductoVista buscar(int articuloId) throws DataAccessException {
		return jdbc.queryForObject("SELECT * FROM productos_vista WHERE articuloId = ?", new ProductoVistaRM(),
				articuloId);
	}

	@Override
	public List<ProductoVista> consultar() throws DataAccessException {
		return jdbc.query("SELECT * FROM productos_vista", new ProductoVistaRM());
	}

}
