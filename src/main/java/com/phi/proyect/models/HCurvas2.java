package com.phi.proyect.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="h_curvas")
public class HCurvas2 implements Serializable{

	@Id
	@JoinColumn(name="Cd_Curva")
	private int CdCurva;
	
	private String FhDate;

	public int getCdCurva() {
		return CdCurva;
	}

	public void setCdCurva(int cdCurva) {
		CdCurva = cdCurva;
	}

	public String getFhDate() {
		return FhDate;
	}

	public void setFhDate(String fhDate) {
		FhDate = fhDate;
	}

	
}
