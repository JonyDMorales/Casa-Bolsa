package com.phi.proyect.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="vector_de_precios_historico")
public class Divisas implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idValmerPriceVector;
	
	private Double marketSurcharge;
	private String tv;
	private Date date;
	
	public Divisas() {
		super();
	}


	
	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
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
