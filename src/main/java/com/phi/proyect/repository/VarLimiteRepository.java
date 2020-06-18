package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phi.proyect.models.VarLimite;

public interface VarLimiteRepository extends JpaRepository<VarLimite, Integer>{

	public List<VarLimite> findByProducto(String producto);
	
	public List<VarLimite> findAll();
}
