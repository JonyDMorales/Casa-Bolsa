package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="var_limite_MD")
public class VarLimite implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idVarLimiteMD;
	
	private String producto;
	private int limite;
	
	
	public VarLimite() {
		super();
	}
	public Integer getIdVarLimiteMD() {
		return idVarLimiteMD;
	}
	public void setIdVarLimiteMD(Integer idVarLimiteMD) {
		this.idVarLimiteMD = idVarLimiteMD;
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
}
