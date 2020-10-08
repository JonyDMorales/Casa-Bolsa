package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="de_swap")
public class DeSwap2 implements Serializable{

	@Id
	private String CdTransaccion;
	
	
	private int NuCurvaDescuento;
	
	
	private int NuFlotante;
	
	private int TpProducto;
	
	
	public DeSwap2() {
		super();
	}


	public String getCdTransaccion() {
		return CdTransaccion;
	}


	public void setCdTransaccion(String cdTransaccion) {
		CdTransaccion = cdTransaccion;
	}


	public int getNuCurvaDescuento() {
		return NuCurvaDescuento;
	}


	public void setNuCurvaDescuento(int nuCurvaDescuento) {
		NuCurvaDescuento = nuCurvaDescuento;
	}


	public int getNuFlotante() {
		return NuFlotante;
	}


	public void setNuFlotante(int nuFlotante) {
		NuFlotante = nuFlotante;
	}


	public int getTpProducto() {
		return TpProducto;
	}


	public void setTpProducto(int tpProducto) {
		TpProducto = tpProducto;
	}

	
}
