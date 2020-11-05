package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.CurvasParametria;

public interface CurvasParametriaRepository extends JpaRepository<CurvasParametria, Integer>{
	
	@Query(value="SELECT * FROM curvas_parametria;", nativeQuery =  true)
	public List<CurvasParametria> curvasParametria();

}
