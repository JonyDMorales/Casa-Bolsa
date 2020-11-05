package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="curvas_parametria")
public class CurvasParametria implements Serializable{
	
	@Id
	private int cdCurva;
	private String columna;
	private String filas;
	private int activo;
	private String createdAt;
	private String updatedAt;
	
	public int getCdCurva() {
		return cdCurva;
	}
	public void setCdCurva(int cdCurva) {
		this.cdCurva = cdCurva;
	}
	public String getColumna() {
		return columna;
	}
	public void setColumna(String columna) {
		this.columna = columna;
	}
	public String getFilas() {
		return filas;
	}
	public void setFilas(String filas) {
		this.filas = filas;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
