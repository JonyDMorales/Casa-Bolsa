package com.phi.proyect.vo;

import java.io.Serializable;

public class MesadeDinero implements Serializable {
	private int idValmerPriceVector;
	private String issue;
	private int limite;
	private Double valorLibros;
	private Double multi;
	
	private Double param1;
	private Double param2;
	private Double param3;



	public MesadeDinero(int idValmerPriceVector, String issue, int limite, Double valorLibros, Double multi, Double param1, Double param2, Double param3) {
		super();
		this.idValmerPriceVector = idValmerPriceVector;
		this.issue = issue;
		this.limite = limite;
		this.valorLibros = valorLibros;
		this.multi = multi;
		
		this.param1=param1;
		this.param2=param2;
		this.param3=param3;
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

	public Double getMulti() {
		return multi;
	}

	public void setMulti(Double multi) {
		this.multi = multi;
	}


	public Double getParam1() {
		return param1;
	}


	public void setParam1(Double param1) {
		this.param1 = param1;
	}


	public Double getParam2() {
		return param2;
	}


	public void setParam2(Double param2) {
		this.param2 = param2;
	}


	public Double getParam3() {
		return param3;
	}


	public void setParam3(Double param3) {
		this.param3 = param3;
	}
	
	

}
