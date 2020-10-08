package com.phi.proyect.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="calculo_de_var_swap")
public class CalculoDeVarSwap {

	@Id
	private String CdTransaccion;
	private Date Fecha;
	private Double Valor;
	private int Porcentaje;
	
	public CalculoDeVarSwap(String cdTransaccion, Date fecha, Double valor, int porcentaje) {
		super();
		CdTransaccion = cdTransaccion;
		Fecha = fecha;
		Valor = valor;
		Porcentaje = porcentaje;
	}
	public String getCdTransaccion() {
		return CdTransaccion;
	}
	public void setCdTransaccion(String cdTransaccion) {
		CdTransaccion = cdTransaccion;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public Double getValor() {
		return Valor;
	}
	public void setValor(Double valor) {
		Valor = valor;
	}
	public int getPorcentaje() {
		return Porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		Porcentaje = porcentaje;
	}
	

	
}
