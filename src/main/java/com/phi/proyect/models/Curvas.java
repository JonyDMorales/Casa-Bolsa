package com.phi.proyect.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="curvas")
public class Curvas implements Serializable{

	@Id
	@JoinColumn(name="Fk_Cd_Curva")
	private int FkCdCurva;
	
	private String FhDate;
	private int NuNodo;
	private Double Valor;
	
	
	
	public Curvas() {
		super();
	}
	public int getFkCdCurva() {
		return FkCdCurva;
	}
	public void setFkCdCurva(int fkCdCurva) {
		FkCdCurva = fkCdCurva;
	}
	
	public String getFhDate() {
		return FhDate;
	}
	public void setFhDate(String fhDate) {
		FhDate = fhDate;
	}
	public int getNuNodo() {
		return NuNodo;
	}
	public void setNuNodo(int nuNodo) {
		NuNodo = nuNodo;
	}
	public Double getValor() {
		return Valor;
	}
	public void setValor(Double valor) {
		Valor = valor;
	}
	
	
}
