package com.robotica.models;

public class Paquete {

	private int id;
	private String nombre;
	private String descripcion;
	private int setId;

	public Paquete() {
		super();
	}

	public Paquete(int id, String nombre, String descripcion, int setId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.setId = setId;
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

	public int getSetId() {
		return setId;
	}

	public void setSetId(int setId) {
		this.setId = setId;
	}

	@Override
	public String toString() {
		return "Paquete [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", setId=" + setId + "]";
	}
	
}
