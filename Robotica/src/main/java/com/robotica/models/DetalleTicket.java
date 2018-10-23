package com.robotica.models;

public class DetalleTicket {

	private int id;
	private int cantidad;
	private float precio;
	private float importe;
	private int articuloId;
	private int ticketId;

	public DetalleTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleTicket(int id, int cantidad, float precio, float importe, int articuloId, int ticketId) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.importe = importe;
		this.articuloId = articuloId;
		this.ticketId = ticketId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public int getArticuloId() {
		return articuloId;
	}

	public void setArticuloId(int articuloId) {
		this.articuloId = articuloId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	@Override
	public String toString() {
		return "DetallesTicket [id=" + id + ", cantidad=" + cantidad + ", precio=" + precio + ", importe=" + importe
				+ ", articuloId=" + articuloId + ", ticketId=" + ticketId + "]";
	}

}
