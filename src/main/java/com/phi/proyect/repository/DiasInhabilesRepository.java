package com.phi.proyect.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.phi.proyect.models.DiasInhabiles;
import org.springframework.stereotype.Component;

@Component
public interface DiasInhabilesRepository extends JpaRepository<DiasInhabiles, Long>{

	public List<DiasInhabiles> findByFecha(Date fecha);
	
}
