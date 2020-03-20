package com.phi.proyect.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="valuacion_md")
public class ValuacionesMd implements Serializable{

	
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Integer idContabilidad;

@Temporal(TemporalType.DATE)
private Date fechaValuacion;
private String valMer;
private Double valorEnLibros;
private String titulos;


public ValuacionesMd() {
	super();
}

public Integer getIdContabilidad() {
	return idContabilidad;
}
public void setIdContabilidad(Integer idContabilidad) {
	this.idContabilidad = idContabilidad;
}
public Date getFechaValuacion() {
	return fechaValuacion;
}
public void setFechaValuacion(Date fechaValuacion) {
	this.fechaValuacion = fechaValuacion;
}
public String getValMer() {
	return valMer;
}
public void setValMer(String valMer) {
	this.valMer = valMer;
}

public Double getValorEnLibros() {
	return valorEnLibros;
}

public void setValorEnLibros(Double valorEnLibros) {
	this.valorEnLibros = valorEnLibros;
}

public String getTitulos() {
	return titulos;
}

public void setTitulos(String titulos) {
	this.titulos = titulos;
}





	
}
