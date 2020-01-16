package com.phi.proyect.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.ValuacionesMd;

public interface ValuacionesMdRepository extends JpaRepository<ValuacionesMd, Integer>  {
	
	
	@Query(value="Select * from valuacion_md v where v.id_contabilidad =:idOperacion and fecha_valuacion =:fecha", nativeQuery =  true)
	public List<ValuacionesMd> findValMer(@Param("idOperacion") int idOperacion,@Param("fecha") String fecha);
	

}
