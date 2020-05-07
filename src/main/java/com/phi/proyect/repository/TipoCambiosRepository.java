package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.TiposCambios;

public interface TipoCambiosRepository extends JpaRepository<TiposCambios, Integer>{

	@Query(value="Select * from tipos_de_cambio  t where t.fecha_alta =:fecha", nativeQuery =  true)
	public List<TiposCambios> findTipoCambioFecha(@Param("fecha") String fecha);
}
