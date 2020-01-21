package com.phi.proyect.vo;

import java.io.Serializable;

public class OperacionesMd implements Serializable {
	
	
	private Integer idOperacionesDirecto;
	private String contraparte;
	private Float multiplicacion;
	private Float reportoDirecto;
	
	

	
	public OperacionesMd(Integer idOperacionesDirecto, String contraparte, Float multiplicacion,
			Float reportoDirecto) {
		super();
		this.idOperacionesDirecto = idOperacionesDirecto;
		this.contraparte = contraparte;
		this.multiplicacion = multiplicacion;
		this.reportoDirecto = reportoDirecto;
	}
	

	public Integer getIdOperacionesDirecto() {
		return idOperacionesDirecto;
	}
	public void setIdOperacionesDirecto(Integer idOperacionesDirecto) {
		this.idOperacionesDirecto = idOperacionesDirecto;
	}
	public String getContraparte() {
		return contraparte;
	}
	public void setContraparte(String contraparte) {
		this.contraparte = contraparte;
	}
	public Float getMultiplicacion() {
		return multiplicacion;
	}
	public void setMultiplicacion(Float multiplicacion) {
		this.multiplicacion = multiplicacion;
	}
	public Float getReportoDirecto() {
		return reportoDirecto;
	}
	public void setReportoDirecto(Float reportoDirecto) {
		this.reportoDirecto = reportoDirecto;
	} 
	
	
	
	
	
	
	
	
	
	

}
