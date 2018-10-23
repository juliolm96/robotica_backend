package com.robotica.models;

public class PaqueteVista {

	private int id;
	private String nombre;
	private String descripcion;
	private int setId;
	private String nombre_set;

	public PaqueteVista(int id, String nombre, String descripcion, int setId, String nombre_set) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.setId = setId;
		this.nombre_set = nombre_set;
	}

	public PaqueteVista() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getNombre_set() {
		return nombre_set;
	}

	public void setNombre_set(String nombre_set) {
		this.nombre_set = nombre_set;
	}

	@Override
	public String toString() {
		return "PaqueteVista [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", setId=" + setId
				+ ", nombre_set=" + nombre_set + "]";
	}

}
