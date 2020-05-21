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
	private Double param1;
	private Double param2;
	private Double param3;
	
	
	
	public VarOperacionesMd(String instrumento, String fecha, Double param1, Double param2, Double param3) {
		super();
		this.instrumento = instrumento;
		this.fecha = fecha;
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
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

	public Double getParam1() {
		return param1;
	}

	public void setParam1(Double param1) {
		this.param1 = param1;
	}

	public Double getParam2() {
		return param2;
	}

	public void setParam2(Double param2) {
		this.param2 = param2;
	}

	public Double getParam3() {
		return param3;
	}

	public void setParam3(Double param3) {
		this.param3 = param3;
	}
	

}
