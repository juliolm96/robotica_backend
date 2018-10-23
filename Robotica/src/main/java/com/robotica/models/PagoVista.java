package com.robotica.models;

import java.sql.Date;

public class PagoVista {

	private int id;
	private Date fecha;
	private int numero;
	private int cantidad;
	private float importe;
	private float precio;
	private int miembroId;
	private int conceptoPagoId;
	private int numero_miembro;
	private String concepto_letra;

	public PagoVista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagoVista(int id, Date fecha, int numero, int cantidad, float importe, float precio, int miembroId,
			int conceptoPagoId, int numero_miembro, String concepto_letra) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.numero = numero;
		this.cantidad = cantidad;
		this.importe = importe;
		this.precio = precio;
		this.miembroId = miembroId;
		this.conceptoPagoId = conceptoPagoId;
		this.numero_miembro = numero_miembro;
		this.concepto_letra = concepto_letra;
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

	public int getNumero_miembro() {
		return numero_miembro;
	}

	public void setNumero_miembro(int numero_miembro) {
		this.numero_miembro = numero_miembro;
	}

	public String getConcepto_letra() {
		return concepto_letra;
	}

	public void setConcepto_letra(String concepto_letra) {
		this.concepto_letra = concepto_letra;
	}

	@Override
	public String toString() {
		return "PagoVista [id=" + id + ", fecha=" + fecha + ", numero=" + numero + ", cantidad=" + cantidad
				+ ", importe=" + importe + ", precio=" + precio + ", miembroId=" + miembroId + ", conceptoPagoId="
				+ conceptoPagoId + ", numero_miembro=" + numero_miembro + ", concepto_letra=" + concepto_letra + "]";
	}

}
