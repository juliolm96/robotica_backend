package com.robotica.models;

import java.util.Date;

public class ClaseVista extends Clase {

	private String nombreSocio;

	public ClaseVista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClaseVista(int id, Date fecha, String hora_entrada, String hora_salida, int clases_tomadas, int socioId) {
		super(id, fecha, hora_entrada, hora_salida, clases_tomadas, socioId);
		// TODO Auto-generated constructor stub
	}

	public ClaseVista(int id, Date fecha, String hora_entrada, String hora_salida, int clases_tomadas, int socioId,
			String nombreSocio) {
		super(id, fecha, hora_entrada, hora_salida, clases_tomadas, socioId);
		this.nombreSocio = nombreSocio;
	}

	public String getNombreSocio() {
		return nombreSocio;
	}

	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}

	@Override
	public String toString() {
		return "ClaseVista [nombreSocio=" + nombreSocio + ", toString()=" + super.toString() + "]";
	}

}
