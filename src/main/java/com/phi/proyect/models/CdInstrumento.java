package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cd_instrumento")
public class CdInstrumento implements Serializable{

	@Id
	@Column(name = "ID_Instrumento")
	private int IDInstrumento;
	
	private String Nombre;

	public CdInstrumento() {
		super();
	}

	public int getIDInstrumento() {
		return IDInstrumento;
	}

	public void setIDInstrumento(int iDInstrumento) {
		IDInstrumento = iDInstrumento;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	
}
