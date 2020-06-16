package com.phi.proyect.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="limites_lineas")
public class LimitesLineas implements Serializable{

	@Id
   // @GeneratedValue(strategy= GenerationType.IDENTITY)
	//@GeneratedValue(generator="system-uuid")
	//@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String contraparte;
   // private Integer id;
	
	
	private Float globalLimit;
	private Float directOperationLimit;
	private Float reportoOperationLimit;
	private Float operationLimitMoneyMarket;
	private Float exchangeMarketLimit;
	private Float limitOperationExchangeMarket;
	private Integer status;
	private Date registrationDate;
	private Date modificationDate;
	private String mercado;
	
	
	public LimitesLineas() {
		super();
	}


	public String getContraparte() {
		return contraparte;
	}


	public void setContraparte(String contraparte) {
		this.contraparte = contraparte;
	}


	public Float getGlobalLimit() {
		return globalLimit;
	}


	public void setGlobalLimit(Float globalLimit) {
		this.globalLimit = globalLimit;
	}


	public Float getDirectOperationLimit() {
		return directOperationLimit;
	}


	public void setDirectOperationLimit(Float directOperationLimit) {
		this.directOperationLimit = directOperationLimit;
	}


	public Float getReportoOperationLimit() {
		return reportoOperationLimit;
	}


	public void setReportoOperationLimit(Float reportoOperationLimit) {
		this.reportoOperationLimit = reportoOperationLimit;
	}


	public Float getOperationLimitMoneyMarket() {
		return operationLimitMoneyMarket;
	}


	public void setOperationLimitMoneyMarket(Float operationLimitMoneyMarket) {
		this.operationLimitMoneyMarket = operationLimitMoneyMarket;
	}


	public Float getExchangeMarketLimit() {
		return exchangeMarketLimit;
	}


	public void setExchangeMarketLimit(Float exchangeMarketLimit) {
		this.exchangeMarketLimit = exchangeMarketLimit;
	}


	public Float getLimitOperationExchangeMarket() {
		return limitOperationExchangeMarket;
	}


	public void setLimitOperationExchangeMarket(Float limitOperationExchangeMarket) {
		this.limitOperationExchangeMarket = limitOperationExchangeMarket;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Date getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}


	public Date getModificationDate() {
		return modificationDate;
	}


	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}


	public String getMercado() {
		return mercado;
	}


	public void setMercado(String mercado) {
		this.mercado = mercado;
	}
	
}
