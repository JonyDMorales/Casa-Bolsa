package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="de_capsfloor")
public class DeCapsfloor implements Serializable{
	
	@Id
	private String CdTransaccion;
	
	@JoinColumn(name="Cd_Instrumento")
	private int CdInstrumento;
	private String FhInicio;
	private String FhFin;
	
	@JoinColumn(name="Nu_Curva_Descuento")
	private int NuCurvaDescuento;
	
	@JoinColumn(name="Nu_Curva_Volatilidad")
	private int NuCurvaVolatilidad;
	private Double NuStrike;
	private Double Tc;
	private int NuNominal;
	private int NuConvencion;
	
	
	public DeCapsfloor() {
		super();
	}
	public String getCdTransaccion() {
		return CdTransaccion;
	}
	public void setCdTransaccion(String cdTransaccion) {
		CdTransaccion = cdTransaccion;
	}
	public int getCdInstrumento() {
		return CdInstrumento;
	}
	public void setCdInstrumento(int cdInstrumento) {
		CdInstrumento = cdInstrumento;
	}
	public String getFhInicio() {
		return FhInicio;
	}
	public void setFhInicio(String fhInicio) {
		FhInicio = fhInicio;
	}
	public String getFhFin() {
		return FhFin;
	}
	public void setFhFin(String fhFin) {
		FhFin = fhFin;
	}
	public int getNuCurvaDescuento() {
		return NuCurvaDescuento;
	}
	public void setNuCurvaDescuento(int nuCurvaDescuento) {
		NuCurvaDescuento = nuCurvaDescuento;
	}
	public int getNuCurvaVolatilidad() {
		return NuCurvaVolatilidad;
	}
	public void setNuCurvaVolatilidad(int nuCurvaVolatilidad) {
		NuCurvaVolatilidad = nuCurvaVolatilidad;
	}
	public Double getNuStrike() {
		return NuStrike;
	}
	public void setNuStrike(Double nuStrike) {
		NuStrike = nuStrike;
	}
	public Double getTc() {
		return Tc;
	}
	public void setTc(Double tc) {
		Tc = tc;
	}
	public int getNuNominal() {
		return NuNominal;
	}
	public void setNuNominal(int nuNominal) {
		NuNominal = nuNominal;
	}
	public int getNuConvencion() {
		return NuConvencion;
	}
	public void setNuConvencion(int nuConvencion) {
		NuConvencion = nuConvencion;
	}
	
	
	

}
