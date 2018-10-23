package com.robotica.models;

public class ActividadVista extends Actividad {

	private String nombreModelo;
	private String fecha;
	private String nombrePaquete;

	public ActividadVista(int id, int claseId, int modeloId, String alcance, String nombreModelo,
			String nombrePaquete) {
		super(id, claseId, modeloId, alcance);
		this.nombreModelo = nombreModelo;
		this.nombrePaquete = nombrePaquete;
	}

	public ActividadVista(int id, int claseId, int modeloId, String alcance) {
		super(id, claseId, modeloId, alcance);
		// TODO Auto-generated constructor stub
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public ActividadVista() {
		super();
	}

	public String getNombreModelo() {
		return nombreModelo;
	}

	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}

	public String getNombrePaquete() {
		return nombrePaquete;
	}

	public void setNombrePaquete(String nombrePaquete) {
		this.nombrePaquete = nombrePaquete;
	}

	@Override
	public String toString() {
		return "ActividadVista [nombreModelo=" + nombreModelo + ", nombrePaquete=" + nombrePaquete + ", toString()="
				+ super.toString() + "]";
	}

}
