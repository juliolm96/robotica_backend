package com.robotica.models;

import java.sql.Time;

public class AsignacionVista {

	private int id;
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private String dia;
	private Time hora_inicial;
	private Time hora_final;
	private int numero_socio;
	
	public AsignacionVista() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public AsignacionVista(int id, String nombre, String apellido_paterno, String apellido_materno, String dia,
			Time hora_inicial, Time hora_final, int numero_socio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.dia = dia;
		this.hora_inicial = hora_inicial;
		this.hora_final = hora_final;
		this.numero_socio = numero_socio;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
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



	public int getNumero_socio() {
		return numero_socio;
	}



	public void setNumero_socio(int numero_socio) {
		this.numero_socio = numero_socio;
	}


	@Override
	public String toString() {
		return "AsignacionVista [id=" + id + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno
				+ ", apellido_materno=" + apellido_materno + ", dia=" + dia + ", hora_inicial=" + hora_inicial
				+ ", hora_final=" + hora_final + ", numero_socio=" + numero_socio + "]";
	}

	
}
