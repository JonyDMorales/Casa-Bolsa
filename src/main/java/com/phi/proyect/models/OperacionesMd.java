package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="operaciones_md")
public class OperacionesMd implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idOperacionesDirecto;
	
	private Integer idStatus;
	private Integer numeroDeTitulos;
	private Float precio;
	private String contraparte;
	private String directoReporto;
	private String nombre;
	private String apellido;
	private String instrumento;
	
	

	
	
	
	public OperacionesMd() {
		super();
	}
	
	
	public Integer getIdOperacionesDirecto() {
		return idOperacionesDirecto;
	}


	public void setIdOperacionesDirecto(Integer idOperacionesDirecto) {
		this.idOperacionesDirecto = idOperacionesDirecto;
	}


	public Integer getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
	public Integer getNumeroDeTitulos() {
		return numeroDeTitulos;
	}
	public void setNumeroDeTitulos(Integer numeroDeTitulos) {
		this.numeroDeTitulos = numeroDeTitulos;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public String getContraparte() {
		return contraparte;
	}
	public void setContraparte(String contraparte) {
		this.contraparte = contraparte;
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


	public String getInstrumento() {
		return instrumento;
	}


	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}
	
	

}
