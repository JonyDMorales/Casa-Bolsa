package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "de_futuros")
public class DeFuturos implements Serializable{

	
	@Id
	private int codigoDeTransaccion;
	
	private int cdInstrumento;
	private String fechaInicio;
	private String fechaFin;
	private int UnCurvaLocal;
	private int UnCurvaForanea;
	private int UnCurvaIndice;
	private double nuPactado;
	private int UnContratos;
	private int UnPosicion;
	private int UnPlazo;
	private int convencion;
	
	
	public DeFuturos() {
		super();
	}


	public int getCodigoDeTransaccion() {
		return codigoDeTransaccion;
	}


	public void setCodigoDeTransaccion(int codigoDeTransaccion) {
		this.codigoDeTransaccion = codigoDeTransaccion;
	}


	public int getCdInstrumento() {
		return cdInstrumento;
	}


	public void setCdInstrumento(int cdInstrumento) {
		this.cdInstrumento = cdInstrumento;
	}


	public String getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}


	public int getUnCurvaLocal() {
		return UnCurvaLocal;
	}


	public void setUnCurvaLocal(int unCurvaLocal) {
		UnCurvaLocal = unCurvaLocal;
	}


	public int getUnCurvaForanea() {
		return UnCurvaForanea;
	}


	public void setUnCurvaForanea(int unCurvaForanea) {
		UnCurvaForanea = unCurvaForanea;
	}


	public int getUnCurvaIndice() {
		return UnCurvaIndice;
	}


	public void setUnCurvaIndice(int unCurvaIndice) {
		UnCurvaIndice = unCurvaIndice;
	}


	public double getNuPactado() {
		return nuPactado;
	}


	public void setNuPactado(double nuPactado) {
		this.nuPactado = nuPactado;
	}


	public int getUnContratos() {
		return UnContratos;
	}


	public void setUnContratos(int unContratos) {
		UnContratos = unContratos;
	}


	public int getUnPosicion() {
		return UnPosicion;
	}


	public void setUnPosicion(int unPosicion) {
		UnPosicion = unPosicion;
	}


	public int getUnPlazo() {
		return UnPlazo;
	}


	public void setUnPlazo(int unPlazo) {
		UnPlazo = unPlazo;
	}


	public int getConvencion() {
		return convencion;
	}


	public void setConvencion(int convencion) {
		this.convencion = convencion;
	}
	
	
	
}
