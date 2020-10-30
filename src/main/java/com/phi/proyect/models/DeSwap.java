package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="de_swap")
public class DeSwap implements Serializable{

	@Id
	private String CdTransaccion;
	
	private int CdInstrumento;
	private String FhInicio;
	private String FhFin;
	private int NuCurvaDescuento;
	
	@Column(name = "Nu_Curva_Desc_Flot")
	private int curvaFlot;
	
	private Double NuFija;
	private int NuFlotante;
	private int NuNominal;
	private Double TcBanco;
	private Double TcCliente;
	private int CdBcoRecibe;
	private Double NuConvencion;
	private int TpProducto;
	private int TpTransaccion;
	private int TpDescuento;
	
	public DeSwap() {
		super();
	}

	public String getCdTransaccion() {
		return CdTransaccion;
	}

	public void setCdTransaccion(String cdTransaccion) {
		CdTransaccion = cdTransaccion;
	}

	public int getCdInstrumento() {
		return CdInstrumento;
	}

	public void setCdInstrumento(int cdInstrumento) {
		CdInstrumento = cdInstrumento;
	}

	public String getFhInicio() {
		return FhInicio;
	}

	public void setFhInicio(String fhInicio) {
		FhInicio = fhInicio;
	}

	public String getFhFin() {
		return FhFin;
	}

	public void setFhFin(String fhFin) {
		FhFin = fhFin;
	}

	public int getNuCurvaDescuento() {
		return NuCurvaDescuento;
	}

	public void setNuCurvaDescuento(int nuCurvaDescuento) {
		NuCurvaDescuento = nuCurvaDescuento;
	}


	public int getCurvaFlot() {
		return curvaFlot;
	}

	public void setCurvaFlot(int curvaFlot) {
		this.curvaFlot = curvaFlot;
	}

	public Double getNuFija() {
		return NuFija;
	}

	public void setNuFija(Double nuFija) {
		NuFija = nuFija;
	}

	public int getNuFlotante() {
		return NuFlotante;
	}

	public void setNuFlotante(int nuFlotante) {
		NuFlotante = nuFlotante;
	}

	public int getNuNominal() {
		return NuNominal;
	}

	public void setNuNominal(int nuNominal) {
		NuNominal = nuNominal;
	}

	public Double getTcBanco() {
		return TcBanco;
	}

	public void setTcBanco(Double tcBanco) {
		TcBanco = tcBanco;
	}

	public Double getTcCliente() {
		return TcCliente;
	}

	public void setTcCliente(Double tcCliente) {
		TcCliente = tcCliente;
	}

	public int getCdBcoRecibe() {
		return CdBcoRecibe;
	}

	public void setCdBcoRecibe(int cdBcoRecibe) {
		CdBcoRecibe = cdBcoRecibe;
	}

	public Double getNuConvencion() {
		return NuConvencion;
	}

	public void setNuConvencion(Double nuConvencion) {
		NuConvencion = nuConvencion;
	}

	public int getTpProducto() {
		return TpProducto;
	}

	public void setTpProducto(int tpProducto) {
		TpProducto = tpProducto;
	}

	public int getTpTransaccion() {
		return TpTransaccion;
	}

	public void setTpTransaccion(int tpTransaccion) {
		TpTransaccion = tpTransaccion;
	}

	public int getTpDescuento() {
		return TpDescuento;
	}

	public void setTpDescuento(int tpDescuento) {
		TpDescuento = tpDescuento;
	}

	
}
