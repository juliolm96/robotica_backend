package com.robotica.models;

public class Producto {

	private int productoId;
	private String concepto;
	private float precio;
	private String codigo;
	private int existencias;
	private String imagen;
	private int articuloId;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(int productoId, String concepto, float precio, String codigo, int existencias, String imagen,
			int articuloId) {
		super();
		this.productoId = productoId;
		this.concepto = concepto;
		this.precio = precio;
		this.codigo = codigo;
		this.existencias = existencias;
		this.imagen = imagen;
		this.articuloId = articuloId;
	}

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int id) {
		this.productoId = id;
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

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getArticuloId() {
		return articuloId;
	}

	public void setArticuloId(int articuloId) {
		this.articuloId = articuloId;
	}

	@Override
	public String toString() {
		return "Producto [id=" + productoId + ", concepto=" + concepto + ", precio=" + precio + ", codigo=" + codigo
				+ ", existencias=" + existencias + ", imagen=" + imagen + ", articuloId=" + articuloId + "]";
	}

}
