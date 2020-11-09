package com.phi.proyect.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.HCurvas;
import com.phi.proyect.models.HCurvas2;

public interface HCurvasRepositiry2 extends JpaRepository<HCurvas2, Integer> {
	
	@Query(value="SELECT Cd_Curva,Fh_Date  FROM h_curvas where Cd_Curva =:curva order by Fh_Date ASC limit 1;", nativeQuery =  true)
	public List<HCurvas2> getUltimoRegistro(@Param("curva") int curva);
	
	
	@Modifying
	@Transactional
	@Query(value = "SET SQL_SAFE_UPDATES = 0;", nativeQuery = true)
	void setSafeMode();
	
	@Modifying
	@Query(value="delete from h_curvas where Fh_Date =:fecha and Cd_Curva=:curva", nativeQuery =  true)
	int deleteUltimo(@Param("fecha") String fecha,@Param("curva") int curva);
	
	@Modifying
	@Query(value="Update parameter set value = (Select getfechaplazo((select value from parameter where id_parameter =0),1)) where id_parameter = 0;", nativeQuery =  true)
	int updateFecha();
	
	
	@Modifying
	@Query(value="Update parameter set value = ((select getfechaanterio(paremeter = 0),1)) where id_parameter = 0;", nativeQuery =  true)
	int updateFechaRetoceso();
	
	
	@Modifying
	@Query(value="delete from h_curvas where Fh_Date =:fecha", nativeQuery =  true)
	void deleteMismaFecha(@Param("fecha") String fecha);
	
	
}
