package com.phi.proyect.vo;

import java.io.Serializable;

public class Logaritmo implements Serializable{

	private Double logaritmo;
	private Double cambioPrecio;

	public Logaritmo(Double logaritmo, Double cambioPrecio) {
		super();
		this.logaritmo = logaritmo;
		this.cambioPrecio = cambioPrecio;
	}

	public Double getLogaritmo() {
		return logaritmo;
	}

	public void setLogaritmo(Double logaritmo) {
		this.logaritmo = logaritmo;
	}

	public Double getCambioPrecio() {
		return cambioPrecio;
	}

	public void setCambioPrecio(Double cambioPrecio) {
		this.cambioPrecio = cambioPrecio;
	}
	
	
	
}
