package com.robotica.models;

public class ModeloVista {

	private int id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private String nombre_paquete;
	private int paqueteId;

	public ModeloVista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModeloVista(int id, String nombre, String descripcion, String imagen, String nombre_paquete, int paqueteId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.nombre_paquete = nombre_paquete;
		this.paqueteId = paqueteId;
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

	public String getNombre_paquete() {
		return nombre_paquete;
	}

	public void setNombre_paquete(String nombre_paquete) {
		this.nombre_paquete = nombre_paquete;
	}

	public int getPaqueteId() {
		return paqueteId;
	}

	public void setPaqueteId(int paqueteId) {
		this.paqueteId = paqueteId;
	}

	@Override
	public String toString() {
		return "ModeloVista [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", nombre_paquete=" + nombre_paquete + ", paqueteId=" + paqueteId + "]";
	}

}
