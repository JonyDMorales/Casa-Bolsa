package com.phi.proyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.Tvaluacionhoy;

public interface TvaluacionhoyRepository extends JpaRepository<Tvaluacionhoy,Integer>{

	@Modifying
	@Query(value="INSERT INTO tvaluacionhoy (Cd_Transaccion,Valuacion) VALUES( :cd, :valuacion)", nativeQuery =  true)
	int save2(@Param("cd") String cd,@Param("valuacion") double valuacion);
}
