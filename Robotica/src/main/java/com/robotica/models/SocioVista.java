package com.robotica.models;

import java.util.Date;

public class SocioVista {

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
	private String nombre_escuela;

	public SocioVista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setNivel_educativo(String nivel_educativo) {
		this.nivel_educativo = nivel_educativo;
	}

	public void setSaldo_clases(int saldo_clases) {
		this.saldo_clases = saldo_clases;
	}

	public void setNombre_escuela(String nombre_escuela) {
		this.nombre_escuela = nombre_escuela;
	}

	public int getId() {
		return id;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public String getTutor() {
		return tutor;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getNivel_educativo() {
		return nivel_educativo;
	}

	public int getSaldo_clases() {
		return saldo_clases;
	}

	public String getNombre_escuela() {
		return nombre_escuela;
	}

	@Override
	public String toString() {
		return "SocioVista [id=" + id + ", fecha_ingreso=" + fecha_ingreso + ", numero=" + numero + ", nombre="
				+ nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", tutor=" + tutor + ", telefono=" + telefono
				+ ", nivel_educativo=" + nivel_educativo + ", saldo_clases=" + saldo_clases + ", nombre_escuela="
				+ nombre_escuela + "]";
	}

}
