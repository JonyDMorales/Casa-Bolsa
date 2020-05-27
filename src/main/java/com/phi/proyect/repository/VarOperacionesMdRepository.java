package com.phi.proyect.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phi.proyect.models.VarOperacionesMd;

public interface VarOperacionesMdRepository  extends JpaRepository<VarOperacionesMd, Integer> {

	public List<VarOperacionesMd> findByFecha(String fecha);
	
}
