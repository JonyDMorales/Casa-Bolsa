package com.phi.proyect.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="calculo_de_var_swap")
public class CalculoDeVarSwap {

	/* nuevos campos que quedaron en la tabla despues de las modificaciones de Jon*/
	@Id
	private String CdInstrumento;
	private String fecha;
	private Double var1;
	private Double var2;
	private Double var3;
	

	
	public CalculoDeVarSwap() {
		super();
	}
	
/*---------------cambios alejandro--------------------*/
	
	public CalculoDeVarSwap(String cdInstrumento, String fecha, Double var1, Double var2, Double var3) {
		super();
		CdInstrumento = cdInstrumento;
		this.fecha = fecha;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
	}
	
	
	
	
	public String getCdInstrumento() {
		return CdInstrumento;
	}

	public void setCdInstrumento(String cdInstrumento) {
		CdInstrumento = cdInstrumento;
	}



	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getVar1() {
		return var1;
	}

	public void setVar1(Double var1) {
		this.var1 = var1;
	}

	public Double getVar2() {
		return var2;
	}

	public void setVar2(Double var2) {
		this.var2 = var2;
	}

	public Double getVar3() {
		return var3;
	}

	public void setVar3(Double var3) {
		this.var3 = var3;
	}

/*-----------------------------------*/
	
	

	

	
}
