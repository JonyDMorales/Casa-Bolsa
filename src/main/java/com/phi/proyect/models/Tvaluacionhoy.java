package com.phi.proyect.models;

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
	private double var1;
	private double var2;
	private double var3;
	
	
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

	public Tvaluacionhoy(String cdTransaccion2, double resultado) {
		super();
		CdTransaccion=cdTransaccion2;
		Valuacion=resultado;
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
	

	
	
}
