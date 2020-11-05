package com.phi.proyect.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tvaluacionhoy")
public class Tvaluacionhoy {

	@Id
	private String CdTransaccion;
	private double Valuacion;
	private int CdInstrumento;
	private String fecha;
	private double var1;
	private double var2;
	private double var3;
	private Integer portafolio;
	
	
	/*---------------cambios alejandro--------------------
	se creo un constructor vacio, se agregaron y cambiaron algunas de las variables de las columnas
	se creo un tercer contructor para evitar problemas en el controller "MercadoDerivadosController"
	*/
	
	public Tvaluacionhoy(String cdTransaccion, double valuacion, int cdInstrumento, double var1, double var2,
			double var3) {
		super();
		CdTransaccion = cdTransaccion;
		Valuacion = valuacion;
		CdInstrumento = cdInstrumento;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
	}
	
	public Tvaluacionhoy() {
		super();
	}
	
	

	public Tvaluacionhoy(String cdTransaccion, double valuacion, int cdInstrumento, String fecha, double var1,
			double var2, double var3, int portafolio) {
		super();
		CdTransaccion = cdTransaccion;
		Valuacion = valuacion;
		CdInstrumento = cdInstrumento;
		this.fecha = fecha;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
		this.portafolio = portafolio;
	}

	public String getCdTransaccion() {
		return CdTransaccion;
	}

	public void setCdTransaccion(String cdTransaccion) {
		CdTransaccion = cdTransaccion;
	}

	public double getValuacion() {
		return Valuacion;
	}

	public void setValuacion(double valuacion) {
		Valuacion = valuacion;
	}

	public int getCdInstrumento() {
		return CdInstrumento;
	}

	public void setCdInstrumento(int cdInstrumento) {
		CdInstrumento = cdInstrumento;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	public Integer getPortafolio() {
		return portafolio;
	}

	public void setPortafolio(Integer portafolio) {
		this.portafolio = portafolio;
	}



	

	
}
