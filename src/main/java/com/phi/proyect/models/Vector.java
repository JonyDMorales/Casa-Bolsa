package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vector_de_precios_historico")
public class Vector implements Serializable{
	@Id
	private Integer idValmerPriceVector;
	private String issue;
	private Float marketSurcharge;
	
	
	public Vector() {
		super();
	}
	public Integer getIdValmerPriceVector() {
		return idValmerPriceVector;
	}
	public void setIdValmerPriceVector(Integer idValmerPriceVector) {
		this.idValmerPriceVector = idValmerPriceVector;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public Float getMarketSurcharge() {
		return marketSurcharge;
	}
	public void setMarketSurcharge(Float marketSurcharge) {
		this.marketSurcharge = marketSurcharge;
	}
	
	

}
