package com.robotica.models;

public class Asignacion {

	private int id;
	private int socio_id;
	private int horario_servicio_id;
	
	public Asignacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Asignacion(int id, int socio_id, int horario_servicio_id) {
		super();
		this.id = id;
		this.socio_id = socio_id;
		this.horario_servicio_id = horario_servicio_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSocio_id() {
		return socio_id;
	}

	public void setSocio_id(int socio_id) {
		this.socio_id = socio_id;
	}

	public int getHorario_servicio_id() {
		return horario_servicio_id;
	}

	public void setHorario_servicio_id(int horario_servicio_id) {
		this.horario_servicio_id = horario_servicio_id;
	}

	@Override
	public String toString() {
		return "Asignacion [id=" + id + ", socio_id=" + socio_id + ", horario_servicio_id=" + horario_servicio_id + "]";
	}

		
	
}
