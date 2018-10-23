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

import com.robotica.models.Ticket;
import com.robotica.models.TicketVista;

@Repository
public class JDBCTicket implements TicketDAO {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public TicketVista buscar(int ticketId) throws DataAccessException {

		return jdbc.queryForObject("SELECT * FROM tickets_vista WHERE id = ?", new TicketVistaRM(), ticketId);

	}

	@Override
	public List<TicketVista> consultar() throws DataAccessException {

		return jdbc.query("SELECT * FROM tickets_vista", new TicketVistaRM());

	}

	@Override
	public int crear(Ticket ticket) throws DataAccessException {

		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);

		List<String> columns = new ArrayList<>();

		columns.add("estado");
		columns.add("SOCIO_id");

		insert.setTableName("TICKETS");
		insert.setColumnNames(columns);

		Map<String, Object> data = new HashMap<>();

		data.put("estado", "E");
		data.put("SOCIO_id", ticket.getSocioId());

		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(data);

		return id.intValue();
	}

	@Override
	public void cancelar(int ticketId) throws DataAccessException {
		jdbc.update("UPDATE TICKETS SET estado = 'C' WHERE id = ?", ticketId);
	}

	@Override
	public void pagar(Ticket ticket) throws DataAccessException {
		jdbc.update("UPDATE TICKETS SET estado = 'P', forma_pago = ? WHERE id = ?", ticket.getForma_pago(),
				ticket.getId());
	}

}
