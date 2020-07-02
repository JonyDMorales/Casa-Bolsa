package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.CdCurvas;

public interface CdCurvasRepository extends JpaRepository<CdCurvas, Integer>{

	@Query(value="SELECT * FROM cd_curvas where Cd_Curva =:id limit 1", nativeQuery =  true)
	public List<CdCurvas> findByCdCurva(@Param("id") int id);
}
