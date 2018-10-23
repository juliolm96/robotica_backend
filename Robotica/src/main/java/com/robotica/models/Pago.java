package com.robotica.models;

import java.sql.Date;

public class Pago {

	private int id;
	private Date fecha;
	private int numero;
	private int cantidad;
	private float importe;
	private float precio;
	private int miembroId;
	private int conceptoPagoId;

	public Pago() {
		super();
	}

	public Pago(int id, Date fecha, int numero, int cantidad, float importe, float precio, int miembroId,
			int conceptoPagoId) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.numero = numero;
		this.cantidad = cantidad;
		this.importe = importe;
		this.precio = precio;
		this.miembroId = miembroId;
		this.conceptoPagoId = conceptoPagoId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getMiembroId() {
		return miembroId;
	}

	public void setMiembroId(int miembroId) {
		this.miembroId = miembroId;
	}

	public int getConceptoPagoId() {
		return conceptoPagoId;
	}

	public void setConceptoPagoId(int conceptoPagoId) {
		this.conceptoPagoId = conceptoPagoId;
	}

	@Override
	public String toString() {
		return "Pago [id=" + id + ", fecha=" + fecha + ", numero=" + numero + ", cantidad=" + cantidad + ", importe="
				+ importe + ", precio=" + precio + ", miembroId=" + miembroId + ", conceptoPagoId=" + conceptoPagoId
				+ "]";
	}

}
