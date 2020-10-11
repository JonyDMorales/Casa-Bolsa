package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;




@Entity
@Immutable
@Table(name = "varportafolioswap")
public class Vista{

	@Id
	private int nu;
	private String fecha;
	private Double pl;
	

	public Vista(int nu, String fecha, Double pl) {
		super();
		this.nu = nu;
		this.fecha = fecha;
		this.pl = pl;
	}

	public Vista() {
		super();
	}

	public int getNu() {
		return nu;
	}
	public void setNu(int nu) {
		this.nu = nu;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getPl() {
		return pl;
	}

	public void setPl(Double pl) {
		this.pl = pl;
	}
	
	
}
