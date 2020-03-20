package com.phi.proyect.vo;

import java.io.Serializable;

public class MesadeDinero implements Serializable {
	private int idValmerPriceVector;
	private String issue;
	private int limite;
	private Double valorLibros;



	public MesadeDinero(int idValmerPriceVector, String issue, int limite, Double valorLibros) {
		super();
		this.idValmerPriceVector = idValmerPriceVector;
		this.issue = issue;
		this.limite = limite;
		this.valorLibros = valorLibros;
	}

	public MesadeDinero() {
		super();
	}

	public int getIdValmerPriceVector() {
		return idValmerPriceVector;
	}

	public void setIdValmerPriceVector(int idValmerPriceVector) {
		this.idValmerPriceVector = idValmerPriceVector;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public Double getValorLibros() {
		return valorLibros;
	}

	public void setValorLibros(Double valorLibros) {
		this.valorLibros = valorLibros;
	}
	
	

}
