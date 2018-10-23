package com.robotica.models;

public class Escuela {

	private int id;
	private String clave;
	private String nombre;
	
	public Escuela() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Escuela(int id, String clave, String nombre) {
		super();
		this.id = id;
		this.clave = clave;
		this.nombre = nombre;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Escuela [id=" + id + ", clave=" + clave + ", nombre=" + nombre + "]";
	}

	
	
}
