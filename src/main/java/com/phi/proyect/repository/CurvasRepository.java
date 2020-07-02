package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.Curvas;

public interface CurvasRepository extends JpaRepository<Curvas, Integer>{

	@Query(value="SELECT * FROM phiinadmin_plataforma.curvas where Fk_Cd_Curva =:id limit 1", nativeQuery =  true)
	public List<Curvas> findByFkCdCurva(@Param("id") int id);
	
	@Modifying
	@Query(value="INSERT INTO curvas (Fk_Cd_Curva,Fh_Date,Nu_Nodo,Valor) VALUES( :id, :fecha, :nodo, :valor)", nativeQuery =  true)
	int save2(@Param("id") int id,@Param("fecha") String fecha,@Param("nodo") int nodo,@Param("valor") double valor);
}
