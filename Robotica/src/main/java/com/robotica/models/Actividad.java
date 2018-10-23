package com.robotica.models;

public class Actividad {

	private int id;
	private int claseId;
	private int modeloId;
	private String alcance;
	
	public Actividad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actividad(int id, int claseId, int modeloId, String alcance) {
		super();
		this.id = id;
		this.claseId = claseId;
		this.modeloId = modeloId;
		this.alcance = alcance;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClaseId() {
		return claseId;
	}

	public void setClaseId(int claseId) {
		this.claseId = claseId;
	}

	public int getModeloId() {
		return modeloId;
	}

	public void setModeloId(int modeloId) {
		this.modeloId = modeloId;
	}

	public String getAlcance() {
		switch (alcance) {
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
			return "Not Handled";
		}
	}

	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}

}