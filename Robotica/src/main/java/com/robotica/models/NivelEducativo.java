package com.robotica.models;

public class NivelEducativo {
	private int id;
	private String descripcion;
	
	public NivelEducativo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NivelEducativo(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
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

	@Override
	public String toString() {
		return "NivelEducativo [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
}
