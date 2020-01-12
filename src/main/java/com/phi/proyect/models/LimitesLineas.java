package com.phi.proyect.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="limites_lineas")
public class LimitesLineas implements Serializable{

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private String contraparte;
   // private Integer id;
	
	
	private Float globalLimit;
	private Float directOperationLimit;
	private Float reportoOperationLimit;
	private Float operationLimitMoneyMarket;
	private Float exchangeMarketLimit;
	private Float limitOperationExchangeMarket;
	private Integer estatus;
	private Date fechaAlta;
	private Date fechaModificacion;
	private String mercado;
	private String usuario;
	
	
	
	public LimitesLineas() {
		super();
	}



	/*public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}*/



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



	public Integer getEstatus() {
		return estatus;
	}



	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}



	public Date getFechaAlta() {
		return fechaAlta;
	}



	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}



	public Date getFechaModificacion() {
		return fechaModificacion;
	}



	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
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


	
	
}
