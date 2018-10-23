package com.robotica.models;

public class Construccion {

	private int id;
	private String material; // BLOB
	private String instruccion; // BLOB
	private String ensamblado; // BLOB
	private int numero;
	private int modeloId;

	public Construccion(int id, String material, String instruccion, String ensamblado, int numero, int modeloId) {
		super();
		this.id = id;
		this.material = material;
		this.instruccion = instruccion;
		this.ensamblado = ensamblado;
		this.numero = numero;
		this.modeloId = modeloId;
	}

	public Construccion() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getInstruccion() {
		return instruccion;
	}

	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}

	public String getEnsamblado() {
		return ensamblado;
	}

	public void setEnsamblado(String ensamblado) {
		this.ensamblado = ensamblado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getModeloId() {
		return modeloId;
	}

	public void setModeloId(int modeloId) {
		this.modeloId = modeloId;
	}

}
