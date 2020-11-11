package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="flujos_swap")
public class FlujosSwap implements Serializable{

	@Id
	@JoinColumn(name="Cd_Transaccion")
	private String CdTransaccion;
	
	private int NuPago;
	private String FhPago;
	private Double NuMontoPago;
	
	private int Nu_PlazoCupon;
	private Double Nu_TasaVigente;
	private int CdActivo;
	private String Fh_Pago_b;
	private Double Nu_Monto_Pago_b;
	private int Nu_PlazoCupon_b;
	
	public FlujosSwap() {
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
		return Nu_PlazoCupon;
	}

	public void setNuPlazoCupon(int nuPlazoCupon) {
		Nu_PlazoCupon = nuPlazoCupon;
	}

	public Double getNuTasaVigente() {
		return Nu_TasaVigente;
	}

	public void setNuTasaVigente(Double nuTasaVigente) {
		Nu_TasaVigente = nuTasaVigente;
	}

	public int getCdActivo() {
		return CdActivo;
	}

	public void setCdActivo(int cdActivo) {
		CdActivo = cdActivo;
	}

	public String getFh_Pago_b() {
		return Fh_Pago_b;
	}

	public void setFh_Pago_b(String fh_Pago_b) {
		Fh_Pago_b = fh_Pago_b;
	}

	public Double getNu_Monto_Pago_b() {
		return Nu_Monto_Pago_b;
	}

	public void setNu_Monto_Pago_b(Double nu_Monto_Pago_b) {
		Nu_Monto_Pago_b = nu_Monto_Pago_b;
	}

	public int getNu_PlazoCupon_b() {
		return Nu_PlazoCupon_b;
	}

	public void setNu_PlazoCupon_b(int nu_PlazoCupon_b) {
		Nu_PlazoCupon_b = nu_PlazoCupon_b;
	}
	
}
