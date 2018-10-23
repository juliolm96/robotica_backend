package com.robotica.models;

public class ServicioVista {

	private int articuloId;
	private String concepto;
	private float precio;
	private String codigo;
	private int servicioId;
	private int dias;
	private String tipo;
	private int paqueteId;
	private String nombrePaquete;

	public ServicioVista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServicioVista(int articuloId, String concepto, float precio, String codigo, int servicioId, int dias,
			String tipo, int paqueteId, String nombrePaquete) {
		super();
		this.articuloId = articuloId;
		this.concepto = concepto;
		this.precio = precio;
		this.codigo = codigo;
		this.servicioId = servicioId;
		this.dias = dias;
		this.tipo = tipo;
		this.paqueteId = paqueteId;
		this.nombrePaquete = nombrePaquete;
	}

	public int getArticuloId() {
		return articuloId;
	}

	public void setArticuloId(int articuloId) {
		this.articuloId = articuloId;
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

	public int getServicioId() {
		return servicioId;
	}

	public void setServicioId(int servicioId) {
		this.servicioId = servicioId;
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

	public int getPaqueteId() {
		return paqueteId;
	}

	public void setPaqueteId(int paqueteId) {
		this.paqueteId = paqueteId;
	}

	public String getNombrePaquete() {
		return nombrePaquete;
	}

	public void setNombrePaquete(String nombrePaquete) {
		this.nombrePaquete = nombrePaquete;
	}

	@Override
	public String toString() {
		return "ServiciosVista [articuloId=" + articuloId + ", concepto=" + concepto + ", precio=" + precio
				+ ", codigo=" + codigo + ", servicioId=" + servicioId + ", dias=" + dias + ", tipo=" + tipo
				+ ", paqueteId=" + paqueteId + ", nombrePaquete=" + nombrePaquete + "]";
	}

}
