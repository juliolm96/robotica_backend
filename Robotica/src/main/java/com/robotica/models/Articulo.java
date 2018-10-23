package com.robotica.models;

public class Articulo {

	private int id;
	private String concepto;
	private float precio;
	private String codigo;

	public Articulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Articulo(int id, String concepto, float precio, String codigo) {
		super();
		this.id = id;
		this.concepto = concepto;
		this.precio = precio;
		this.codigo = codigo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", concepto=" + concepto + ", precio=" + precio + ", codigo=" + codigo + "]";
	}

}
