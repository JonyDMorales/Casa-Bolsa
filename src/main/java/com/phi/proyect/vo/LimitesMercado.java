package com.phi.proyect.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LimitesMercado implements Serializable{

private String mercado;
	
	private Double globalLimit;
	private Double directOperationLimit;
	private Double reportoOperationLimit;
	private Double operationLimitMoneyMarket;
	private Double exchangeMarketLimit;
	private Double limitOperationExchangeMarket;
	private int status;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date registrationDate;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date modificationDate;
	
	
	
	public LimitesMercado(String mercado, Double globalLimit, Double directOperationLimit, Double reportoOperationLimit,
			Double operationLimitMoneyMarket, Double exchangeMarketLimit, Double limitOperationExchangeMarket,
			int status, Date registrationDate, Date modificationDate) {
		super();
		this.mercado = mercado;
		this.globalLimit = globalLimit;
		this.directOperationLimit = directOperationLimit;
		this.reportoOperationLimit = reportoOperationLimit;
		this.operationLimitMoneyMarket = operationLimitMoneyMarket;
		this.exchangeMarketLimit = exchangeMarketLimit;
		this.limitOperationExchangeMarket = limitOperationExchangeMarket;
		this.status = status;
		this.registrationDate = registrationDate;
		this.modificationDate = modificationDate;
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
