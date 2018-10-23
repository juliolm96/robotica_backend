package com.robotica.models;

public class Modelo {

	private int id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private int paquete_id;
	
	public Modelo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Modelo(int id, String nombre, String descripcion, String imagen, int paquete_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.paquete_id = paquete_id;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getPaquete_id() {
		return paquete_id;
	}

	public void setPaquete_id(int paquete_id) {
		this.paquete_id = paquete_id;
	}

	@Override
	public String toString() {
		return "Modelo [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", PAQUETE_id=" + paquete_id + "]";
	}
	
	
}
