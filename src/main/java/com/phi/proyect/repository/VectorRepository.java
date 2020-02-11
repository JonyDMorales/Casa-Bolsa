package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.phi.proyect.models.Vector;

public interface VectorRepository extends JpaRepository<Vector, Integer>{

	
	@Query(value="Select * from vector_de_precios_historico v where v.issue =:descripcion order by date DESC LIMIT :limites", nativeQuery =  true)
	public List<Vector>findIssue(@Param("descripcion") String descripcion,@Param("limites") int limites);
}
