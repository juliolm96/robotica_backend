package com.robotica.models;

public class SuscripcionVista {

	private int id;
	private String vigencia;
	private int vigente; // 1 = vigente, 2 = vencido
	private int socioId;
	private String nombre_socio;
	private int paqueteId;
	private String nombre_paquete;

	public SuscripcionVista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuscripcionVista(int id, String vigencia, int vigente, int socioId, String nombre_socio, int paqueteId,
			String nombre_paquete) {
		super();
		this.id = id;
		this.vigencia = vigencia;
		this.vigente = vigente;
		this.socioId = socioId;
		this.nombre_socio = nombre_socio;
		this.paqueteId = paqueteId;
		this.nombre_paquete = nombre_paquete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVigencia() {
		return vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}

	public int getVigente() {
		return vigente;
	}

	public void setVigente(int vigente) {
		this.vigente = vigente;
	}

	public int getSocioId() {
		return socioId;
	}

	public void setSocioId(int socioId) {
		this.socioId = socioId;
	}

	public String getNombre_socio() {
		return nombre_socio;
	}

	public void setNombre_socio(String nombre_socio) {
		this.nombre_socio = nombre_socio;
	}

	public int getPaqueteId() {
		return paqueteId;
	}

	public void setPaqueteId(int paqueteId) {
		this.paqueteId = paqueteId;
	}

	public String getNombre_paquete() {
		return nombre_paquete;
	}

	public void setNombre_paquete(String nombre_paquete) {
		this.nombre_paquete = nombre_paquete;
	}

	@Override
	public String toString() {
		return "SuscripcionVista [id=" + id + ", vigencia=" + vigencia + ", vigente=" + vigente + ", socioId=" + socioId
				+ ", nombre_socio=" + nombre_socio + ", paqueteId=" + paqueteId + ", nombre_paquete=" + nombre_paquete
				+ "]";
	}

}
