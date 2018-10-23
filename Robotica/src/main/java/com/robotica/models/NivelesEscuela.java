package com.robotica.models;

public class NivelesEscuela {

	private int id;
	private int escuelaId;
	private int nivelEducativoId;
	
	public NivelesEscuela() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NivelesEscuela(int id, int escuelaId, int nivelEducativoId) {
		super();
		this.id = id;
		this.escuelaId = escuelaId;
		this.nivelEducativoId = nivelEducativoId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEscuelaId() {
		return escuelaId;
	}

	public void setEscuelaId(int escuelaId) {
		this.escuelaId = escuelaId;
	}

	public int getNivelEducativoId() {
		return nivelEducativoId;
	}

	public void setNivelEducativoId(int nivelEducativoId) {
		this.nivelEducativoId = nivelEducativoId;
	}

	@Override
	public String toString() {
		return "NivelesEscuela [id=" + id + ", escuelaId=" + escuelaId + ", nivelEducativoId=" + nivelEducativoId + "]";
	}

	
}
