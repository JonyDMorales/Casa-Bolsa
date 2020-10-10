package com.phi.proyect.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.CalculoDeVarSwap;

public interface CalculoDeVarSwapRepository extends JpaRepository<CalculoDeVarSwap, Integer>{

	@Modifying
	@Query(value="INSERT INTO calculo_de_var_swap (Cd_Transaccion,Fecha,Valor,Porcentaje) VALUES( :calculo, :fecha, :valor, :porcentaje)", nativeQuery =  true)
	int save2(@Param("calculo") String calculo,@Param("fecha") Date fecha,@Param("valor") double valor,@Param("porcentaje") int porcentaje);
	
	@Query(value="select * from calculo_de_var_swap WHERE cd_instrumento =:cdInstrumento", nativeQuery =  true)
	public List<CalculoDeVarSwap> findByCdInstrumento(@Param("cdInstrumento") String cdInstrumento);
}
