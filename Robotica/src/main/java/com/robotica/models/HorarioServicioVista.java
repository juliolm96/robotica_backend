package com.robotica.models;

import java.sql.Time;

public class HorarioServicioVista {
	private int id;
	private String dia;
	private Time hora_inicial;
	private Time hora_final;
	private int capacidad;
	private int disponible;
	
	
	public HorarioServicioVista() {
		super();
		// TODO Auto-generated constructor stub
	}


	public HorarioServicioVista(int id, String dia, Time hora_inicial, Time hora_final, int capacidad, int disponible) {
		super();
		this.id = id;
		this.dia = dia;
		this.hora_inicial = hora_inicial;
		this.hora_final = hora_final;
		this.capacidad = capacidad;
		this.disponible = disponible;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDia() {
		return dia;
	}


	public void setDia(String dia) {
		this.dia = dia;
	}


	public Time getHora_inicial() {
		return hora_inicial;
	}


	public void setHora_inicial(Time hora_inicial) {
		this.hora_inicial = hora_inicial;
	}


	public Time getHora_final() {
		return hora_final;
	}


	public void setHora_final(Time hora_final) {
		this.hora_final = hora_final;
	}


	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public int getDisponible() {
		return disponible;
	}


	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}


	@Override
	public String toString() {
		return "HorarioServicioVista [id=" + id + ", dia=" + dia + ", hora_inicial=" + hora_inicial + ", hora_final="
				+ hora_final + ", capacidad=" + capacidad + ", disponible=" + disponible + "]";
	}
	
	
}
