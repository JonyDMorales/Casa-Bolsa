package com.phi.proyect.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


public class HCurvas implements Serializable{

	private Integer CdCurva;
	
	private String FhDate;
	
	//private List<String> lista;

	public Integer getCdCurva() {
		return CdCurva;
	}

	public void setCdCurva(Integer cdCurva) {
		CdCurva = cdCurva;
	}

	public String getFhDate() {
		return FhDate;
	}

	public void setFhDate(String fhDate) {
		FhDate = fhDate;
	}

	@Override
	public String toString() {
		return "HCurvas [CdCurva=" + CdCurva + ", FhDate=" + FhDate + "]";
	}

	

	
	
	
	}
