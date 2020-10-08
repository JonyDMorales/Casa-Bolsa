package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeSwapRepository2 extends JpaRepository<com.phi.proyect.models.DeSwap2, Integer>{
	
	public List<com.phi.proyect.models.DeSwap2> findAll();

}
