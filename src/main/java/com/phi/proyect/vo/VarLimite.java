package com.phi.proyect.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VarLimite implements Serializable{
	
	private Integer idVarLimiteMd;

	private String producto;
	private int limite;
	private double globalLimit;
	private double directOperationLimit;
	private double reportoOperationLimit;
	private double operationLimitMoneyMarket;
	private double exchangeMarketLimit;
	private double limitOperationExchangeMarket;
	private int status;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date registrationDate;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date modificationDate;
	private String market;
	
	
	
	public VarLimite(Integer idVarLimiteMd, String producto, int limite, double globalLimit,
			double directOperationLimit, double reportoOperationLimit, double operationLimitMoneyMarket,
			double exchangeMarketLimit, double limitOperationExchangeMarket, int status, Date registrationDate,
			Date modificationDate) {
		super();
		this.idVarLimiteMd = idVarLimiteMd;
		this.producto = producto;
		this.limite = limite;
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
	
	
	
	public Integer getIdVarLimiteMd() {
		return idVarLimiteMd;
	}
	public void setIdVarLimiteMd(Integer idVarLimiteMd) {
		this.idVarLimiteMd = idVarLimiteMd;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getLimite() {
		return limite;
	}
	public void setLimite(int limite) {
		this.limite = limite;
	}
	public double getGlobalLimit() {
		return globalLimit;
	}
	public void setGlobalLimit(double globalLimit) {
		this.globalLimit = globalLimit;
	}
	public double getDirectOperationLimit() {
		return directOperationLimit;
	}
	public void setDirectOperationLimit(double directOperationLimit) {
		this.directOperationLimit = directOperationLimit;
	}
	public double getReportoOperationLimit() {
		return reportoOperationLimit;
	}
	public void setReportoOperationLimit(double reportoOperationLimit) {
		this.reportoOperationLimit = reportoOperationLimit;
	}
	public double getOperationLimitMoneyMarket() {
		return operationLimitMoneyMarket;
	}
	public void setOperationLimitMoneyMarket(double operationLimitMoneyMarket) {
		this.operationLimitMoneyMarket = operationLimitMoneyMarket;
	}
	public double getExchangeMarketLimit() {
		return exchangeMarketLimit;
	}
	public void setExchangeMarketLimit(double exchangeMarketLimit) {
		this.exchangeMarketLimit = exchangeMarketLimit;
	}
	public double getLimitOperationExchangeMarket() {
		return limitOperationExchangeMarket;
	}
	public void setLimitOperationExchangeMarket(double limitOperationExchangeMarket) {
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



	public String getMarket() {
		return market;
	}



	public void setMarket(String market) {
		this.market = market;
	}
	
	
	

}
