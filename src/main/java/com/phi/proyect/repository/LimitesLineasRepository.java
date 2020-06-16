package com.phi.proyect.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.phi.proyect.models.LimitesLineas;

public interface LimitesLineasRepository extends JpaRepository<LimitesLineas, Integer> {
	
	public LimitesLineas findByContraparte(String contraparte);
	
	public List<LimitesLineas> findAll();

	public List<LimitesLineas> findByStatus(Integer status);

}
