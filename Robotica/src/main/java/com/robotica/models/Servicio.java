package com.robotica.models;

public class Servicio {

	private int id;
	private String concepto;
	private float precio;
	private String codigo;
	private int dias;
	private String tipo;
	private int articuloId;
	private int paqueteId;

	public Servicio() {
		
		super();
		
	}

	public Servicio(int id, String concepto, float precio, String codigo, int dias, String tipo, int articuloId,
			int paqueteId) {
		super();
		this.id = id;
		this.concepto = concepto;
		this.precio = precio;
		this.codigo = codigo;
		this.dias = dias;
		this.tipo = tipo;
		this.articuloId = articuloId;
		this.paqueteId = paqueteId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getArticuloId() {
		return articuloId;
	}

	public void setArticuloId(int articuloId) {
		this.articuloId = articuloId;
	}

	public int getPaqueteId() {
		return paqueteId;
	}

	public void setPaqueteId(int paqueteId) {
		this.paqueteId = paqueteId;
	}

	@Override
	public String toString() {
		return "Servicio [id=" + id + ", concepto=" + concepto + ", precio=" + precio + ", codigo=" + codigo + ", dias="
				+ dias + ", tipo=" + tipo + ", articuloId=" + articuloId + ", paqueteId=" + paqueteId + "]";
	}

}
