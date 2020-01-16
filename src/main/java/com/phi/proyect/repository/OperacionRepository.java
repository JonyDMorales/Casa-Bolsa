package com.phi.proyect.repository;


import com.phi.proyect.models.OperacionesMd;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;




/*Se debe crear un crud por tabla*/


public interface OperacionRepository extends JpaRepository<OperacionesMd, Integer> {
	
	public List<OperacionesMd> findAll();
}
