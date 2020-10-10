package com.phi.proyect.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.repository.FuncionesRepository;

@Service
@Transactional(readOnly = true)
public class FuncionesService {
	
	@Autowired
	private FuncionesRepository fr;
	
	public Date getfechaanterior(Date fecha,int dias){
		return this.fr.getfechaanterior(fecha, dias);
	}
	
	public double ValFuDivisas(String CdTransaccion, int CdCurva,Date LdFecha,int CdIndice,int CdCurvaFor ) {
		return this.fr.ValFuDivisas(CdTransaccion, CdCurva, LdFecha, CdIndice, CdCurvaFor);
	}

	public double ValFuIndices(String CdTransaccion, int CdCurva,Date LdFecha,int CdIndice ) {
		return this.fr.ValFuIndices(CdTransaccion, CdCurva, LdFecha, CdIndice);
	}
	
	public double ValFuTasas(String CdTransaccion, int CdCurva,Date LdFecha) {
		return this.fr.ValFuTasas(CdTransaccion, CdCurva, LdFecha);
	}
	
	public double ValSwapStarting(String CdTransaccion, int CdCurva,Date LdFecha) {
		return this.fr.ValSwapStarting(CdTransaccion, CdCurva, LdFecha);
	}
	
	public double ValSwapTiieFijo(String CdTransaccion, int CdCurva,Date LdFecham, int cdDescuento) {
		return this.fr.ValSwapTiieFijo(CdTransaccion, CdCurva, LdFecham,cdDescuento);
	}

	public double VaRFuDivisas(String CdTransaccion, int CdCurva,Date LdFecha,int CdIndice,int CdCurvaFor ) {
		return this.fr.VaRFuDivisas(CdTransaccion, CdCurva, LdFecha, CdIndice, CdCurvaFor);
	}

	public double VaRFuIndices(String CdTransaccion, int CdCurva,Date LdFecha,int CdIndice ) {
		return this.fr.VaRFuIndices(CdTransaccion, CdCurva, LdFecha, CdIndice);
	}
	
	public double VaRFuTasas(String CdTransaccion, int CdCurva,Date LdFecha) {
		return this.fr.VaRFuTasas(CdTransaccion, CdCurva, LdFecha);
	}
	
	public double VarPPPPPPP(String CdTransaccion, int CdCurva,Date LdFecha) {
		return this.fr.VarPPPPPPP(CdTransaccion, CdCurva, LdFecha);
	}
	
	public double VaRSwapTiieFijo(String CdTransaccion, int CdCurva,Date LdFecham, int cdDescuento,int NuPercentil) {
		return this.fr.VaRSwapTiieFijo(CdTransaccion, CdCurva, LdFecham, cdDescuento, NuPercentil);
	}
	
}