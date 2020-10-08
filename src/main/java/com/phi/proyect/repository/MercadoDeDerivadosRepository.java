package com.phi.proyect.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.DeSwap;

public interface MercadoDeDerivadosRepository extends JpaRepository<DeSwap, Integer>{
	
	@Query(value="SELECT Value FROM parameter where Id_Parameter =:id;", nativeQuery =  true)
	public String getValue(@Param("id") int id);

}
