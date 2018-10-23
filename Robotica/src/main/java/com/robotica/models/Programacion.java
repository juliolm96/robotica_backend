package com.robotica.models;

public class Programacion {
	
	private int id;
	private String instruccion;
	private int numero;
	private int modelo_id;
	
	public Programacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Programacion(int id, String instruccion, int numero, int modelo_id) {
		super();
		this.id = id;
		this.instruccion = instruccion;
		this.numero = numero;
		this.modelo_id = modelo_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstruccion() {
		return instruccion;
	}

	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getModelo_id() {
		return modelo_id;
	}

	public void setModelo_id(int modelo_id) {
		this.modelo_id = modelo_id;
	}

	@Override
	public String toString() {
		return "Programacion [id=" + id + ", instruccion=" + instruccion + ", numero=" + numero + ", MODELO_id="
				+ modelo_id + "]";
	}
	
	
}
