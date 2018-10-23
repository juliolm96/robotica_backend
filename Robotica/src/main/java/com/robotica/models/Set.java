package com.robotica.models;

public class Set {

	private int id;
	private String numero;
	private String nombre;
	private String descripcion;

	public Set() {
		super();
	}

	public Set(int id, String numero, String nombre, String descripcion) {
		super();
		this.id = id;
		this.numero = numero;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Sets [id=" + id + ", numero=" + numero + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

}
