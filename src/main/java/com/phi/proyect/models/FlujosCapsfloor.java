package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="flujos_capsfloor")
public class FlujosCapsfloor implements Serializable{

	@Id
	@JoinColumn(name="Cd_Transaccion")
	private String CdTransaccion;
	
	private int NuPago;
	private String FhPago;
	private Double NuMontoPago;
	private int NuPlazoCupon;
	private Double NuTasaVigente;
	private int CdActivo;
	
	public FlujosCapsfloor() {
		super();
	}

	public String getCdTransaccion() {
		return CdTransaccion;
	}

	public void setCdTransaccion(String cdTransaccion) {
		CdTransaccion = cdTransaccion;
	}

	public int getNuPago() {
		return NuPago;
	}

	public void setNuPago(int nuPago) {
		NuPago = nuPago;
	}

	public String getFhPago() {
		return FhPago;
	}

	public void setFhPago(String fhPago) {
		FhPago = fhPago;
	}

	public Double getNuMontoPago() {
		return NuMontoPago;
	}

	public void setNuMontoPago(Double nuMontoPago) {
		NuMontoPago = nuMontoPago;
	}

	public int getNuPlazoCupon() {
		return NuPlazoCupon;
	}

	public void setNuPlazoCupon(int nuPlazoCupon) {
		NuPlazoCupon = nuPlazoCupon;
	}

	public Double getNuTasaVigente() {
		return NuTasaVigente;
	}

	public void setNuTasaVigente(Double nuTasaVigente) {
		NuTasaVigente = nuTasaVigente;
	}

	public int getCdActivo() {
		return CdActivo;
	}

	public void setCdActivo(int cdActivo) {
		CdActivo = cdActivo;
	}
	
	
	
}
