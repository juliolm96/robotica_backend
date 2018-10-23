package com.robotica.models;

public class ProductoVista {

	private int articuloId;
	private String concepto;
	private float precio;
	private String codigo;
	private String imagen;
	private int productoId;
	private int existencias;

	public ProductoVista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductoVista(int articuloId, String concepto, float precio, String codigo, String imagen, int productoId,
			int existencias) {
		super();
		this.articuloId = articuloId;
		this.concepto = concepto;
		this.precio = precio;
		this.codigo = codigo;
		this.imagen = imagen;
		this.productoId = productoId;
		this.existencias = existencias;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}

	@Override
	public String toString() {
		return "ProductoVista [articuloId=" + articuloId + ", concepto=" + concepto + ", precio=" + precio + ", codigo="
				+ codigo + ", imagen=" + imagen + ", productoId=" + productoId + ", existencias=" + existencias + "]";
	}

}
