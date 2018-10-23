package com.robotica.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.robotica.models.ConceptoPago;

@Repository
public class JDBCConceptoPago implements ConceptoPagoDAO{

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public void crear(ConceptoPago cp) throws DataAccessException {
		jdbc.update("INSERT INTO CONCEPTOS_PAGO (clave,concepto,numero_clases,precio) VALUES (?,?,?,?)",
					cp.getClave(),cp.getConcepto(),cp.getNumero_clases(),cp.getPrecio());
	}

	@Override
	public void actualizar(ConceptoPago cp) throws DataAccessException {
		
		jdbc.update("UPDATE CONCEPTOS_PAGO SET "
					+ "clave = ?,"
					+ "concepto = ?,"
					+ "numero_clases = ?,"
					+ "precio = ? "
					+ "WHERE id = ?",
					cp.getClave(),
					cp.getConcepto(),
					cp.getNumero_clases(),
					cp.getPrecio(),
					cp.getId());
	}

	@Override
	public ConceptoPago buscar(int id) throws DataAccessException {
		
		ConceptoPago cp = jdbc.queryForObject("SELECT * FROM CONCEPTOS_PAGO WHERE id = ?", new ConceptoPagoRM(), id);
		
		return cp;
	}

	@Override
	public List<ConceptoPago> consultar() throws DataAccessException {
		
		List<ConceptoPago> cp = jdbc.query("SELECT * FROM CONCEPTOS_PAGO", new ConceptoPagoRM());
		
		return cp;
	}

}
