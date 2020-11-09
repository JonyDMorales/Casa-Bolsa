package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeSwapRepository2 extends JpaRepository<com.phi.proyect.models.DeSwap2, Integer>{
	
	public List<com.phi.proyect.models.DeSwap2> findAll();

	@Modifying
	@Query(value="delete from flujos_swap where Cd_Transaccion =:id", nativeQuery =  true)
	int deleteAll(@Param("id") String data);

}
