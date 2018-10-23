package com.robotica.models;

public class NivelesEscuelaVista {

	public int id; // El de la escuela
	public String nombre;
	public String descripcion;

	
	public NivelesEscuelaVista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NivelesEscuelaVista(int id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "NivelesEscuelaVista [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

}
