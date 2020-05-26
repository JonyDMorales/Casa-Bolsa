
package com.phi.proyect.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="de_capsfloor")
public class Caps implements Serializable {
	
	@Id 

	
	private String cdTransaccion;
	
	
	private Integer cdInstrumento;
	private Date fhInicio;
	private Date fhFin;
	private Integer nuCurvaDescuento;
	private Integer nuCurvaVolatilidad;
	private Float nuStrike;
	private Float tc;
	private Integer nuNominal;
	private Integer nuConvencion;
	
	
	public Caps() {
		super();
	}


	public String getCdTransaccion() {
		return cdTransaccion;
	}


	public void setCdTransaccion(String cdTransaccion) {
		this.cdTransaccion = cdTransaccion;
	}


	public Integer getCdInstrumento() {
		return cdInstrumento;
	}


	public void setCdInstrumento(Integer cdInstrumento) {
		this.cdInstrumento = cdInstrumento;
	}


	public Date getFhInicio() {
		return fhInicio;
	}


	public void setFhInicio(Date fhInicio) {
		this.fhInicio = fhInicio;
	}


	public Date getFhFin() {
		return fhFin;
	}


	public void setFhFin(Date fhFin) {
		this.fhFin = fhFin;
	}


	public Integer getNuCurvaDescuento() {
		return nuCurvaDescuento;
	}


	public void setNuCurvaDescuento(Integer nuCurvaDescuento) {
		this.nuCurvaDescuento = nuCurvaDescuento;
	}


	public Integer getNuCurvaVolatilidad() {
		return nuCurvaVolatilidad;
	}


	public void setNuCurvaVolatilidad(Integer nuCurvaVolatilidad) {
		this.nuCurvaVolatilidad = nuCurvaVolatilidad;
	}


	public Float getNuStrike() {
		return nuStrike;
	}


	public void setNuStrike(Float nuStrike) {
		this.nuStrike = nuStrike;
	}


	public Float getTc() {
		return tc;
	}


	public void setTc(Float tc) {
		this.tc = tc;
	}


	public Integer getNuNominal() {
		return nuNominal;
	}


	public void setNuNominal(Integer nuNominal) {
		this.nuNominal = nuNominal;
	}


	public Integer getNuConvencion() {
		return nuConvencion;
	}


	public void setNuConvencion(Integer nuConvencion) {
		this.nuConvencion = nuConvencion;
	}







}
