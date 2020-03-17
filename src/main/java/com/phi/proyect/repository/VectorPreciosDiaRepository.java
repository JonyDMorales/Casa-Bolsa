package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.VectorPreciosDia;

public interface VectorPreciosDiaRepository extends JpaRepository<VectorPreciosDia, Integer>{

	
	@Query(value="Select * from vector_de_precios_dia  v where v.issue =:producto", nativeQuery =  true)
	public List<VectorPreciosDia> findVectorPrecioDia(@Param("producto") String producto);
	
	
	public List<VectorPreciosDia> findAll();
}
