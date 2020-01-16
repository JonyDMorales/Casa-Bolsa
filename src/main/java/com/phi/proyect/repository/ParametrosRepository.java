package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.Parametros;


public interface ParametrosRepository extends JpaRepository<Parametros, Integer> {
	
	
	@Query(value="Select * from parametros p where p.descripcion =:descripcion", nativeQuery =  true)
	public List<Parametros>findParametro(@Param("descripcion") String descripcion);

}
