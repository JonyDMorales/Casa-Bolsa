package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="vector_de_precio_historico")
public class Divisas implements Serializable {

	@Id
	private Integer idValmerPriceVector;
	
	private Double marketSurcharge;
	private String tv;

	
	public Divisas() {
		super();
	}

	

	public Double getMarketSurcharge() {
		return marketSurcharge;
	}

	public void setMarketSurcharge(Double marketSurcharge) {
		this.marketSurcharge = marketSurcharge;
	}



	public String getTv() {
		return tv;
	}



	public void setTv(String tv) {
		this.tv = tv;
	}



	public Integer getIdValmerPriceVector() {
		return idValmerPriceVector;
	}



	public void setIdValmerPriceVector(Integer idValmerPriceVector) {
		this.idValmerPriceVector = idValmerPriceVector;
	}
	
	
	
	

}
