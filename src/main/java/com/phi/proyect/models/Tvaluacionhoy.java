package com.phi.proyect.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tvaluacionhoy")
public class Tvaluacionhoy {

	@Id
	private String CdTransaccion;
	private double Valuacion;
	
	public Tvaluacionhoy(String cdTransaccion, double valuacion) {
		super();
		CdTransaccion = cdTransaccion;
		Valuacion = valuacion;
	}
	public String getCdTransaccion() {
		return CdTransaccion;
	}
	public void setCdTransaccion(String cdTransaccion) {
		CdTransaccion = cdTransaccion;
	}
	public double getValuacion() {
		return Valuacion;
	}
	public void setValuacion(double valuacion) {
		Valuacion = valuacion;
	}
	
	
}
