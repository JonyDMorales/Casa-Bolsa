package com.phi.proyect.vo;

import java.io.Serializable;

public class MesaDerivados implements Serializable {
	
	private String producto;
	private double valuacion;
	private double var1;
	private double var2;
	private double var3;
	private double limite;
	
	
	public MesaDerivados(String producto, double valuacion, double var1, double var2, double var3, double limite) {
		super();
		this.producto = producto;
		this.valuacion = valuacion;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
		this.limite = limite;
	}
	
	
	
	public MesaDerivados() {
		super();
	}



	public String getProducto() {
		return producto;
	}



	public void setProducto(String producto) {
		this.producto = producto;
	}



	public double getValuacion() {
		return valuacion;
	}



	public void setValuacion(double valuacion) {
		this.valuacion = valuacion;
	}



	public double getVar1() {
		return var1;
	}



	public void setVar1(double var1) {
		this.var1 = var1;
	}



	public double getVar2() {
		return var2;
	}



	public void setVar2(double var2) {
		this.var2 = var2;
	}



	public double getVar3() {
		return var3;
	}



	public void setVar3(double var3) {
		this.var3 = var3;
	}



	public double getLimite() {
		return limite;
	}



	public void setLimite(double limite) {
		this.limite = limite;
	}
	

}
