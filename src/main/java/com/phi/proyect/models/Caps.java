
package com.phi.proyect.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="de_capsfloor")
public class Caps implements Serializable {
	
	@Id
	private String CdTransaccion;
	
	
	private Integer CdInstrumento;
	private String FhInicio;
	private String FhFin;
	private Integer NuCurvaDescuento;
	private Integer NuCurvaVolatilidad;
	private Double NuStrike;
	private Double Tc;
	private Integer NuNominal;
	private Integer NuConvencion;
	
	
	public Caps() {
		super();
	}


	public String getCdTransaccion() {
		return CdTransaccion;
	}


	public void setCdTransaccion(String cdTransaccion) {
		CdTransaccion = cdTransaccion;
	}


	public Integer getCdInstrumento() {
		return CdInstrumento;
	}


	public void setCdInstrumento(Integer cdInstrumento) {
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


	public Integer getNuCurvaDescuento() {
		return NuCurvaDescuento;
	}


	public void setNuCurvaDescuento(Integer nuCurvaDescuento) {
		NuCurvaDescuento = nuCurvaDescuento;
	}


	public Integer getNuCurvaVolatilidad() {
		return NuCurvaVolatilidad;
	}


	public void setNuCurvaVolatilidad(Integer nuCurvaVolatilidad) {
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


	public Integer getNuNominal() {
		return NuNominal;
	}


	public void setNuNominal(Integer nuNominal) {
		NuNominal = nuNominal;
	}


	public Integer getNuConvencion() {
		return NuConvencion;
	}


	public void setNuConvencion(Integer nuConvencion) {
		NuConvencion = nuConvencion;
	}


	
}
