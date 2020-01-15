package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.phi.proyect.models.Divisas;



public interface DivisasRepository extends JpaRepository<Divisas,Integer> {
	
	
	/**
	 * Método para consultar las reservas por cliente
	 * 
	 * @param cliente
	 * @return
	 */
	@Query("Select market_surcharge from vector_de_precios_historico v where v.tv =:divisa")
	public List<Divisas> findByTv(String divisa);
	

	
	
	

}
