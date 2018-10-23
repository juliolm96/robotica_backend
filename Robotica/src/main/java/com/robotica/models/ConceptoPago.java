package com.robotica.models;

public class ConceptoPago {

	private int id;
	private String clave;
	private String concepto;
	private int numero_clases;
	private float precio;

	public ConceptoPago() {
		super();
	}

	public ConceptoPago(int id, String clave, String concepto, int numero_clases, float precio) {
		super();
		this.id = id;
		this.clave = clave;
		this.concepto = concepto;
		this.numero_clases = numero_clases;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public float getNumero_clases() {
		return numero_clases;
	}

	public void setNumero_clases(int numero_clases) {
		this.numero_clases = numero_clases;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "ConceptoPago [id=" + id + ", clave=" + clave + ", concepto=" + concepto + ", numero_clases=" + numero_clases
				+ ", precio=" + precio + "]";
	}

}
