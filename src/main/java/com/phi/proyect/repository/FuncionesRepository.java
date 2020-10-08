package com.phi.proyect.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.Divisas;

public interface FuncionesRepository extends JpaRepository<Divisas, String>{
	
	
	@Query(value="SELECT getfechaanterior(:fecha,:dias);", nativeQuery =  true)
	public Date getfechaanterior(@Param("fecha") Date fecha,@Param("dias") int dias);
	
	@Query(value="SELECT ValFuDivisas(:CdTransaccion,:CdCurva,:LdFecha,:CdIndice,:CdCurvaFor);", nativeQuery =  true)
	public double ValFuDivisas(@Param("CdTransaccion") String CdTransaccion,@Param("CdCurva") int CdCurva,@Param("LdFecha") Date LdFecha,@Param("CdIndice") int CdIndice,@Param("CdCurvaFor") int CdCurvaFor);
	
	@Query(value="SELECT ValFuIndices(:CdTransaccion,:CdCurva,:LdFecha,:CdIndice);", nativeQuery =  true)
	public double ValFuIndices(@Param("CdTransaccion") String CdTransaccion,@Param("CdCurva") int CdCurva,@Param("LdFecha") Date LdFecha,@Param("CdIndice") int CdIndice);
	
	@Query(value="SELECT ValFuTasas(:CdTransaccion,:CdCurva,:LdFecha);", nativeQuery =  true)
	public double ValFuTasas(@Param("CdTransaccion") String CdTransaccion,@Param("CdCurva") int CdCurva,@Param("LdFecha") Date LdFecha);

	@Query(value="SELECT ValSwapStarting(:CdTransaccion,:CdCurva,:LdFecha);", nativeQuery =  true)
	public double ValSwapStarting(@Param("CdTransaccion") String CdTransaccion,@Param("CdCurva") int CdCurva,@Param("LdFecha") Date LdFecha);

	@Query(value="SELECT ValSwapTiieFijo(:CdTransaccion,:CdCurva,:LdFecha,:CdDescuento);", nativeQuery =  true)
	public double ValSwapTiieFijo(@Param("CdTransaccion") String CdTransaccion,@Param("CdCurva") int CdCurva,@Param("LdFecha") Date LdFecha,@Param("CdDescuento") int CdDescuento);

	@Query(value="SELECT VaRFuDivisas(:CdTransaccion,:CdCurva,:LdFecha,:CdIndice,:CdCurvaFor);", nativeQuery =  true)
	public double VaRFuDivisas(@Param("CdTransaccion") String CdTransaccion,@Param("CdCurva") int CdCurva,@Param("LdFecha") Date LdFecha,@Param("CdIndice") int CdIndice,@Param("CdCurvaFor") int CdCurvaFor);
	
	@Query(value="SELECT VaRFuIndices(:CdTransaccion,:CdCurva,:LdFecha,:CdIndice);", nativeQuery =  true)
	public double VaRFuIndices(@Param("CdTransaccion") String CdTransaccion,@Param("CdCurva") int CdCurva,@Param("LdFecha") Date LdFecha,@Param("CdIndice") int CdIndice);
	
	@Query(value="SELECT VaRFuTasas(:CdTransaccion,:CdCurva,:LdFecha);", nativeQuery =  true)
	public double VaRFuTasas(@Param("CdTransaccion") String CdTransaccion,@Param("CdCurva") int CdCurva,@Param("LdFecha") Date LdFecha);

	@Query(value="SELECT VarPPPPPPP(:CdTransaccion,:CdCurva,:LdFecha);", nativeQuery =  true)
	public double VarPPPPPPP(@Param("CdTransaccion") String CdTransaccion,@Param("CdCurva") int CdCurva,@Param("LdFecha") Date LdFecha);
	
	@Query(value="SELECT VaRSwapTiieFijo(:CdTransaccion,:CdCurva,:LdFecha,:CdDescuento,:NuPercentil);", nativeQuery =  true)
	public double VaRSwapTiieFijo(@Param("CdTransaccion") String CdTransaccion,@Param("CdCurva") int CdCurva,@Param("LdFecha") Date LdFecha,@Param("CdDescuento") int CdDescuento,@Param("NuPercentil") int NuPercentil);
}
