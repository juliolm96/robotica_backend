package com.robotica.models;

import java.sql.Date;

public class Ticket {

	private int id;
	private String folio;
	private Date fecha;
	/******************/
	private Date hora;
	/********************/
	private float subtotal;
	private float iva;
	private float total;
	private String forma_pago;
	private String estado;
	private int socioId;

	public Ticket() {
		super();
	}

	public Ticket(int id, String folio, Date fecha, Date hora, float subtotal, float iva, float total,
			String forma_pago, String estado, int socioId) {
		super();
		this.id = id;
		this.folio = folio;
		this.fecha = fecha;
		this.hora = hora;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.forma_pago = forma_pago;
		this.estado = estado;
		this.socioId = socioId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getForma_pago() {
		return forma_pago;
	}

	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getSocioId() {
		return socioId;
	}

	public void setSocioId(int socioId) {
		this.socioId = socioId;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", folio=" + folio + ", fecha=" + fecha + ", hora=" + hora + ", subtotal="
				+ subtotal + ", iva=" + iva + ", total=" + total + ", forma_pago=" + forma_pago + ", estado=" + estado
				+ ", socioId=" + socioId + "]";
	}

}
