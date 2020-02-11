package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parametros")
public class Logaritmo implements Serializable{

	@Id
	private int idParametros;
	private String descripcion;
	private String valorDelParametro;
	
	
	
	public Logaritmo() {
		super();
	}
	public int getIdParametros() {
		return idParametros;
	}
	public void setIdParametros(int idParametros) {
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
