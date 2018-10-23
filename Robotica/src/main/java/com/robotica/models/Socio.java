package com.robotica.models;

import java.util.Date;

public class Socio {

	private int id;
	private Date fecha_ingreso;
	private int numero;
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private Date fecha_nacimiento;
	private String tutor;
	private String telefono;
	private String nivel_educativo;
	private int saldo_clases;
	private int escuela_id;
	
	public Socio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Socio(int id, Date fecha_ingreso, int numero, String nombre, String apellido_paterno,
			String apellido_materno, Date fecha_nacimiento, String tutor, String telefono, String nivel_educativo,
			int saldo_clases, int escuela_id) {
		super();
		this.id = id;
		this.fecha_ingreso = fecha_ingreso;
		this.numero = numero;
		this.nombre = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.fecha_nacimiento = fecha_nacimiento;
		this.tutor = tutor;
		this.telefono = telefono;
		this.nivel_educativo = nivel_educativo;
		this.saldo_clases = saldo_clases;
		this.escuela_id = escuela_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNivel_educativo() {
		return nivel_educativo;
	}

	public void setNivel_educativo(String nivel_educativo) {
		this.nivel_educativo = nivel_educativo;
	}

	public int getSaldo_clases() {
		return saldo_clases;
	}

	public void setSaldo_clases(int saldo_clases) {
		this.saldo_clases = saldo_clases;
	}

	public int getESCUELA_id() {
		return escuela_id;
	}

	public void setESCUELA_id(int escuela_id) {
		this.escuela_id = escuela_id;
	}

	@Override
	public String toString() {
		return "Socio [id=" + id + ", fecha_ingreso=" + fecha_ingreso + ", numero=" + numero + ", nombre=" + nombre
				+ ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", tutor=" + tutor + ", telefono=" + telefono
				+ ", nivel_educativo=" + nivel_educativo + ", saldo_clases=" + saldo_clases + ", escuela_id="
				+ escuela_id + "]";
	}

	
}
