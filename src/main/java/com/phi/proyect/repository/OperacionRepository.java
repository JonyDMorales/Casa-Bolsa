package com.phi.proyect.repository;


import com.phi.proyect.models.OperacionesMd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




/*Se debe crear un crud por tabla*/


public interface OperacionRepository extends JpaRepository<OperacionesMd, Integer> {
	
	public List<OperacionesMd> findAll();
	
	
	@Query(value="Select * from operaciones_md o where o.contraparte =:contraparte and (id_status=3 or id_status=6)", nativeQuery =  true)
	public List<OperacionesMd> find(@Param("contraparte") String contraparte);
	
	@Query(value="Select * from operaciones_md o where o.contraparte =:contraparte and id_status=4", nativeQuery =  true)
	public List<OperacionesMd> find2(@Param("contraparte") String contraparte);
	
	
	@Query(value="Select * from operaciones_md o where id_status=3", nativeQuery =  true)
	public List<OperacionesMd> findStatus();
}
