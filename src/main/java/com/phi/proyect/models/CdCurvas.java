package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="h_curvas")
public class CdCurvas implements Serializable{
	
	@Id
	private int CdCurva;

	private String Nombre; 

	
	
	public CdCurvas() {
		super();
	}

	public int getCdCurva() {
		return CdCurva;
	}

	public void setCdCurva(int cdCurva) {
		CdCurva = cdCurva;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
}
