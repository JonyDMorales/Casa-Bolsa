package com.phi.proyect.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.VarOperacionesMd;

public interface VarOperacionesMdRepository  extends JpaRepository<VarOperacionesMd, Integer> {

	public List<VarOperacionesMd> findByFecha(String fecha);
	
	@Query(value="SELECT * FROM var_operaciones_md WHERE fecha=:fecha AND instrumento=:producto limit 1", nativeQuery =  true)
	public List<VarOperacionesMd> findByFechaAndProducto(@Param("fecha") String fecha,@Param("producto") String producto);
	
}
