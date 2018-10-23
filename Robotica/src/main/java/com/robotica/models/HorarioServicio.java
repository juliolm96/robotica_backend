package com.robotica.models;

import java.sql.Time;

public class HorarioServicio {
	
	private int id;
	private String dia;
	private Time hora_inicial;
	private Time hora_final;
	private int capacidad;
	
	public HorarioServicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HorarioServicio(int id, String dia, Time hora_inicial, Time hora_final, int capacidad) {
		super();
		this.id = id;
		this.dia = dia;
		this.hora_inicial = hora_inicial;
		this.hora_final = hora_final;
		this.capacidad = capacidad;
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

	@Override
	public String toString() {
		return "HorarioServicio [id=" + id + ", dia=" + dia + ", hora_inicial=" + hora_inicial + ", hora_final="
				+ hora_final + ", capacidad=" + capacidad + "]";
	}

	
}
