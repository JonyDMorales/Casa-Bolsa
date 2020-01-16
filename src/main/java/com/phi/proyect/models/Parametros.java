package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="parametros")
public class Parametros implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idParametros;
	
	private String descripcion;
	private String valorDelParametro;
	
	public Parametros() {
		super();
	}
	
	public Integer getIdParametros() {
		return idParametros;
	}
	public void setIdParametros(Integer idParametros) {
		this.idParametros = idParametros;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getValorDelParametro() {
		return valorDelParametro;
	}
	public void setValorDelParametro(String valorDelParametro) {
		this.valorDelParametro = valorDelParametro;
	}
	
	

}
