package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "var_operaciones_md")
public class VarOperacionesMd implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVarOperacionesMd;

	private String instrumento;
	private String fecha;
	private Double varNoventaNueve;
	private Double varNoventaSiete;
	private Double varNoventaCinco;
	
	
	


	public VarOperacionesMd(String instrumento, String fecha, Double varNoventaNueve,
			Double varNoventaSiete, Double varNoventaCinco) {
		super();
		this.instrumento = instrumento;
		this.fecha = fecha;
		this.varNoventaNueve = varNoventaNueve;
		this.varNoventaSiete = varNoventaSiete;
		this.varNoventaCinco = varNoventaCinco;
	}

	public VarOperacionesMd() {
		super();
	}

	public Integer getIdVarOperacionesMd() {
		return idVarOperacionesMd;
	}

	public void setIdVarOperacionesMd(Integer idVarOperacionesMd) {
		this.idVarOperacionesMd = idVarOperacionesMd;
	}

	public String getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getVarNoventaNueve() {
		return varNoventaNueve;
	}

	public void setVarNoventaNueve(Double varNoventaNueve) {
		this.varNoventaNueve = varNoventaNueve;
	}

	public Double getVarNoventaSiete() {
		return varNoventaSiete;
	}

	public void setVarNoventaSiete(Double varNoventaSiete) {
		this.varNoventaSiete = varNoventaSiete;
	}

	public Double getVarNoventaCinco() {
		return varNoventaCinco;
	}

	public void setVarNoventaCinco(Double varNoventaCinco) {
		this.varNoventaCinco = varNoventaCinco;
	}

	
}
