package com.phi.proyect.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "limites_var_md")
public class VarLimite implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private String registrationDate;
	private String modificationDate;

	
	public VarLimite() {
		super();
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


	public String getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}


	public String getModificationDate() {
		return modificationDate;
	}


	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}


	
	
	

}
