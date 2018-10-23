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

import com.robotica.models.DetalleTicket;
import com.robotica.models.DetalleTicketVista;

@Repository
public class JDBCDetalleTicket implements DetalleTicketDAO {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<DetalleTicketVista> consultar(int ticketId) throws DataAccessException {
		return jdbc.query("SELECT * FROM detalles_ticket_vista WHERE ticketId = ?", new DetalleTicketVistaRM(),
				ticketId);
	}

	@Override
	public void actualizarCantidad(DetalleTicket detalletTicket) throws DataAccessException {
		jdbc.update("UPDATE DETALLES_TICKET SET cantidad = ? WHERE id = ?", detalletTicket.getCantidad(),
				detalletTicket.getId());
	}

	@Override
	public void eliminar(int detalleTicketId) throws DataAccessException {
		jdbc.update("DELETE FROM DETALLES_TICKET WHERE id = ?", detalleTicketId);
	}

	@Override
	public int crear(DetalleTicket detalleTicket) throws DataAccessException {

		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);

		List<String> columns = new ArrayList<>();

		columns.add("cantidad");
		columns.add("ARTICULO_id");
		columns.add("TICKET_id");

		insert.setTableName("DETALLES_TICKET");
		insert.setColumnNames(columns);

		Map<String, Object> data = new HashMap<>();

		data.put("cantidad", detalleTicket.getCantidad());
		data.put("ARTICULO_id", detalleTicket.getArticuloId());
		data.put("TICKET_id", detalleTicket.getTicketId());

		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(data);

		return id.intValue();

	}

	@Override
	public int verificar(DetalleTicket detalleTicket) throws DataAccessException {
		return jdbc.queryForObject("SELECT id FROM detalles_ticket_vista " + "WHERE ticketId = ? AND articuloId = ?",
				Integer.class, detalleTicket.getTicketId(), detalleTicket.getArticuloId());
	}

}
