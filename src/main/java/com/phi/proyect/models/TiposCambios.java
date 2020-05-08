package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tipos_de_cambio")
public class TiposCambios implements Serializable{
	@Id
	private Integer idCambio;
	private Double cambioUdi;
	
	
	
	public TiposCambios() {
		super();
	}



	public Integer getIdCambio() {
		return idCambio;
	}



	public void setIdCambio(Integer idCambio) {
		this.idCambio = idCambio;
	}



	public Double getCambioUdi() {
		return cambioUdi;
	}



	public void setCambioUdi(Double cambioUdi) {
		this.cambioUdi = cambioUdi;
	}
	

	

}
