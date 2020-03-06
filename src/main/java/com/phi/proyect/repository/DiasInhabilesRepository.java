package com.phi.proyect.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phi.proyect.models.DiasInhabiles;

public interface DiasInhabilesRepository extends JpaRepository<DiasInhabiles,String>{
	
	public List<DiasInhabiles> findByFecha(Date fecha);
	
}
