package com.robotica.models;

import java.util.Date;

public class Clase {

	private int id;
	private Date fecha;
	private String hora_entrada;
	private String hora_salida;
	private int clases_tomadas;
	private int socioId;

	public Clase(int id, Date fecha, String hora_entrada, String hora_salida, int clases_tomadas, int socioId) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora_entrada = hora_entrada;
		this.hora_salida = hora_salida;
		this.clases_tomadas = clases_tomadas;
		this.socioId = socioId;
	}

	public Clase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(String hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public String getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}

	public int getClases_tomadas() {
		return clases_tomadas;
	}

	public void setClases_tomadas(int clases_tomadas) {
		this.clases_tomadas = clases_tomadas;
	}

	public int getSocioId() {
		return socioId;
	}

	public void setSocioId(int socioId) {
		this.socioId = socioId;
	}

	@Override
	public String toString() {

		return "Clase [id=" + id + ", fecha=" + fecha + ", hora_entrada=" + hora_entrada + ", hora_salida="
				+ hora_salida + ", clases_tomadas=" + clases_tomadas + ", socioId=" + socioId + "]";
	}

}