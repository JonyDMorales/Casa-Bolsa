package com.phi.proyect.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="limites_mercado")
public class LimitesMercado implements Serializable{

	@Id
	private String mercado;
	
	private Double globalLimit;
	private Double directOperationLimit;
	private Double reportoOperationLimit;
	private Double operationLimitMoneyMarket;
	private Double exchangeMarketLimit;
	private Double limitOperationExchangeMarket;
	private int status;
	private Date registrationDate;	
	private Date modificationDate;
	
	public LimitesMercado() {
		super();
	}

	public String getMercado() {
		return mercado;
	}

	public void setMercado(String mercado) {
		this.mercado = mercado;
	}

	public Double getGlobalLimit() {
		return globalLimit;
	}

	public void setGlobalLimit(Double globalLimit) {
		this.globalLimit = globalLimit;
	}

	public Double getDirectOperationLimit() {
		return directOperationLimit;
	}

	public void setDirectOperationLimit(Double directOperationLimit) {
		this.directOperationLimit = directOperationLimit;
	}

	public Double getReportoOperationLimit() {
		return reportoOperationLimit;
	}

	public void setReportoOperationLimit(Double reportoOperationLimit) {
		this.reportoOperationLimit = reportoOperationLimit;
	}

	public Double getOperationLimitMoneyMarket() {
		return operationLimitMoneyMarket;
	}

	public void setOperationLimitMoneyMarket(Double operationLimitMoneyMarket) {
		this.operationLimitMoneyMarket = operationLimitMoneyMarket;
	}

	public Double getExchangeMarketLimit() {
		return exchangeMarketLimit;
	}

	public void setExchangeMarketLimit(Double exchangeMarketLimit) {
		this.exchangeMarketLimit = exchangeMarketLimit;
	}

	public Double getLimitOperationExchangeMarket() {
		return limitOperationExchangeMarket;
	}

	public void setLimitOperationExchangeMarket(Double limitOperationExchangeMarket) {
		this.limitOperationExchangeMarket = limitOperationExchangeMarket;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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
	
	
	
}
