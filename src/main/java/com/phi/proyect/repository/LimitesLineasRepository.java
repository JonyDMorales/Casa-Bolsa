package com.phi.proyect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phi.proyect.models.LimitesLineas;


public interface LimitesLineasRepository extends JpaRepository<LimitesLineas, Integer> {
	
	public Optional<LimitesLineas> findById(Integer id);
	
	public List<LimitesLineas> findAll();

}
