package com.robotica.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.robotica.models.Pago;
import com.robotica.models.PagoVista;

@Repository
public class JDBCPago implements PagoDAO{

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public void crear(Pago p) throws DataAccessException {
		jdbc.update("INSERT INTO PAGOS "
				+ "(cantidad,precio,MIEMBRO_id,CONCEPTO_PAGO_id) VALUES (?,?,?,?)",
				p.getCantidad(),p.getPrecio(),p.getMiembroId(),p.getConceptoPagoId());
	}

	@Override
	public void actualizar(Pago p) throws DataAccessException {
		jdbc.update("UPDATE PAGOS SET "
				+ "cantidad = ?,"
				+ "precio = ?,"
				+ "MIEMBRO_id = ?,"
				+ "CONCEPTO_PAGO_id = ? "
				+ "WHERE id = ?",
				p.getCantidad(),
				p.getPrecio(),
				p.getMiembroId(),
				p.getConceptoPagoId(),
				p.getId());
		
	}

	@Override
	public Pago buscar(int id) throws DataAccessException {
		return jdbc.queryForObject("SELECT * FROM PAGOS WHERE id = ?", new PagoRM(), id);
	}

	@Override
	public List<Pago> consultar() throws DataAccessException {
		return jdbc.query("SELECT * FROM PAGOS", new PagoRM());
	}

	@Override
	public List<PagoVista> consultarVista() throws DataAccessException {
		return jdbc.query("SELECT * FROM PAGOS_VISTA", new PagoVistaRM());
	}

	@Override
	public PagoVista buscarVista(int id) throws DataAccessException {
		return jdbc.queryForObject("SELECT * FROM PAGOS_VISTA WHERE id = ?", new PagoVistaRM(), id);
	}

}
