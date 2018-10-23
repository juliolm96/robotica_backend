package com.robotica.models;

public class Suscripcion {
	
	private int id;
	private int miembroId;
	private int paqueteId;
	
	public Suscripcion() {
		super();
	}
	
	public Suscripcion(int id, int miembroId, int paqueteId) {
		super();
		this.id = id;
		this.miembroId = miembroId;
		this.paqueteId = paqueteId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMiembroId() {
		return miembroId;
	}
	public void setMiembroId(int miembroId) {
		this.miembroId = miembroId;
	}
	public int getPaqueteId() {
		return paqueteId;
	}
	public void setPaqueteId(int paqueteId) {
		this.paqueteId = paqueteId;
	}
	
	@Override
	public String toString() {
		return "Suscripcion [id=" + id + ", miembroId=" + miembroId + ", paqueteId=" + paqueteId + "]";
	}
	
}
