package com.phi.proyect.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.DeSwap;

public interface MercadoDeDerivadosRepository extends JpaRepository<DeSwap, Integer>{
	
	@Query(value="Select getfechaplazo((select value from parameter where id_parameter = 0),1);", nativeQuery =  true)
	public String getValue();


	@Query(value="select value from parameter where id_parameter = 0", nativeQuery =  true)
	public String getValueDate();

}
