package com.phi.proyect.vo;

import java.io.Serializable;

public class OperacionesMd implements Serializable {
	
	
	private Integer idOperacionesDirecto;
	private String contraparte;
	private Float multiplicacion;
	private Float reportoDirecto;
	private String directoReporto;
	private String nombre;
	private String apellido;

	
	public OperacionesMd(Integer idOperacionesDirecto, String contraparte, Float multiplicacion,
			Float reportoDirecto,String directoReporto,String nombre,String apellido) {
		super();
		this.idOperacionesDirecto = idOperacionesDirecto;
		this.contraparte = contraparte;
		this.multiplicacion = multiplicacion;
		this.reportoDirecto = reportoDirecto;
		this.directoReporto = directoReporto;
		this.nombre = nombre;
		this.apellido = apellido;
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


	public String getDirectoReporto() {
		return directoReporto;
	}


	public void setDirectoReporto(String directoReporto) {
		this.directoReporto = directoReporto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	} 

}
