package com.robotica.models;

public class DetalleTicketVista {

	private int id;
	private int cantidad;
	private float precio;
	private float importe;
	private int articuloId;
	private String conceptoArticulo;
	private String codigoArticulo;
	private int ticketId;

	public DetalleTicketVista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleTicketVista(int id, int cantidad, float precio, float importe, int articuloId,
			String conceptoArticulo, String codigoArticulo, int ticketId) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.importe = importe;
		this.articuloId = articuloId;
		this.conceptoArticulo = conceptoArticulo;
		this.codigoArticulo = codigoArticulo;
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

	public String getConceptoArticulo() {
		return conceptoArticulo;
	}

	public void setConceptoArticulo(String conceptoArticulo) {
		this.conceptoArticulo = conceptoArticulo;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	@Override
	public String toString() {
		return "DetallesTicketVista [id=" + id + ", cantidad=" + cantidad + ", precio=" + precio + ", importe="
				+ importe + ", articuloId=" + articuloId + ", conceptoArticulo=" + conceptoArticulo
				+ ", codigoArticulo=" + codigoArticulo + ", ticketId=" + ticketId + "]";
	}

}
