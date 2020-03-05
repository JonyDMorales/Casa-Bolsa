package com.phi.proyect.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vector_de_precios_dia")
public class VectorPreciosDia implements Serializable {
	@Id
	private Integer idalmerPriceVector;
	private String tv;
	private Double cuponRate;
	private Date couponStart;
	private Date couponEnd;
	private Date expirationDate;
	private String discountCurve;
	private Double yield;
	private Double marketSurcharge;
	private Double updatedNominalValue;

	public VectorPreciosDia() {
		super();
	}

	public Integer getIdalmerPriceVector() {
		return idalmerPriceVector;
	}

	public void setIdalmerPriceVector(Integer idalmerPriceVector) {
		this.idalmerPriceVector = idalmerPriceVector;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	public Double getCuponRate() {
		return cuponRate;
	}

	public void setCuponRate(Double cuponRate) {
		this.cuponRate = cuponRate;
	}

	public Date getCouponStart() {
		return couponStart;
	}

	public void setCouponStart(Date couponStart) {
		this.couponStart = couponStart;
	}

	public Date getCouponEnd() {
		return couponEnd;
	}

	public void setCouponEnd(Date couponEnd) {
		this.couponEnd = couponEnd;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getDiscountCurve() {
		return discountCurve;
	}

	public void setDiscountCurve(String discountCurve) {
		this.discountCurve = discountCurve;
	}

	public Double getYield() {
		return yield;
	}

	public void setYield(Double yield) {
		this.yield = yield;
	}

	public Double getMarketSurcharge() {
		return marketSurcharge;
	}

	public void setMarketSurcharge(Double marketSurcharge) {
		this.marketSurcharge = marketSurcharge;
	}

	public Double getUpdatedNominalValue() {
		return updatedNominalValue;
	}

	public void setUpdatedNominalValue(Double updatedNominalValue) {
		this.updatedNominalValue = updatedNominalValue;
	}

}
