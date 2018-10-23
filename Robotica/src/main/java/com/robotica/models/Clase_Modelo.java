package com.robotica.models;

public class Clase_Modelo {

	int id;
	String descripcion;
	String imagen;
	String nombre;
	int paqueteId;
	int claseId;
	String nombre_paquete;
	String alcance;

	public Clase_Modelo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clase_Modelo(int id, String descripcion, String imagen, String nombre, int paqueteId, int claseId,
			String nombre_paquete) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.nombre = nombre;
		this.paqueteId = paqueteId;
		this.claseId = claseId;
		this.nombre_paquete = nombre_paquete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPaqueteId() {
		return paqueteId;
	}

	public void setPaqueteId(int paqueteId) {
		this.paqueteId = paqueteId;
	}

	public int getClaseId() {
		return claseId;
	}

	public void setClaseId(int claseId) {
		this.claseId = claseId;
	}

	public String getNombre_paquete() {
		return nombre_paquete;
	}

	public void setNombre_paquete(String nombre_paquete) {
		this.nombre_paquete = nombre_paquete;
	}
	
	public String getAlcance() {
		
		switch(alcance) {
			case "I":
				return "Inconcluso";
			case "C":
				return "Construido";
			case "P": 
				return "Programado";
			case "F":
				return "Funcional";
			case "M":
				return "Modificado";
			default:
				return "NotHandled";
		}
		
	}

	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}

	@Override
	public String toString() {
		return "Clase_Modelo [id=" + id + ", descripcion=" + descripcion + ", imagen=" + imagen + ", nombre=" + nombre
				+ ", paqueteId=" + paqueteId + ", claseId=" + claseId + ", nombre_paquete=" + nombre_paquete + "]";
	}

}
