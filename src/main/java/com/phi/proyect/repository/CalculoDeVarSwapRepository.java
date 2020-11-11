package com.phi.proyect.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.CalculoDeVarSwap;

public interface CalculoDeVarSwapRepository extends JpaRepository<CalculoDeVarSwap, Integer>{

	@Modifying
	@Query(value="INSERT INTO calculo_de_var_swap (cd_instrumento,fecha,var1,var2,var3) VALUES( :cd, :fecha, :var1, :var2, :var3)", nativeQuery =  true)
	int saveDeVarSwap(@Param("cd") String cd,@Param("fecha") String fecha,@Param("var1") double valor,@Param("var2") double var2,@Param("var3") double var3);
	
	@Query(value="select * from calculo_de_var_swap WHERE cd_instrumento =:cdInstrumento AND fecha = :fecha", nativeQuery =  true)
	public List<CalculoDeVarSwap> findByCdInstrumento(@Param("cdInstrumento") String cdInstrumento, @Param("fecha") String fecha);
	
	@Query(value="select * from calculo_de_var_swap WHERE fecha =:fecha", nativeQuery =  true)
	public List<CalculoDeVarSwap> findByFecha(@Param("fecha") String fecha);
	
	@Modifying
	@Transactional
	@Query(value = "SET SQL_SAFE_UPDATES = 0;", nativeQuery = true)
	void setSafeMode();
	
	@Modifying
	@Query(value="delete from calculo_de_var_swap where fecha =:fecha", nativeQuery =  true)
	void deleteUltimo(@Param("fecha") String fecha);
}
