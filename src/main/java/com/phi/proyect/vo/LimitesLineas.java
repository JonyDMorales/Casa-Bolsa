package com.phi.proyect.vo;

import java.io.Serializable;

public class LimitesLineas implements Serializable{
	private String contraparte;
	private Float globalLimit;
	private Float directOperationLimit;
	private Float reportoOperationLimit;
	private Float operationLimitMoneyMarket;
	private Float exchangeMarketLimit;
	private Float limitOperationExchangeMarket;
	private String mercado;
	private String usuario;
	private Integer estatus;
	
	
	
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
	public String getMercado() {
		return mercado;
	}
	public void setMercado(String mercado) {
		this.mercado = mercado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	
	
	
}
