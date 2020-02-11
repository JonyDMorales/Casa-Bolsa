package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phi.proyect.models.Logaritmo;

public interface LogaritmoRepository extends JpaRepository<Logaritmo,Integer>{

	
	public List<Logaritmo> findByDescripcion(String descripcion);
}
