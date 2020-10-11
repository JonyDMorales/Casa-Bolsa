package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.phi.proyect.models.CalculoDeVarSwap;
import com.phi.proyect.models.Vista;


public interface VistaRepository extends JpaRepository<Vista, Integer>{

	@Query(value="SELECT * FROM varportafolioswap", nativeQuery =  true)
	public List<Vista> selectVista();
}
