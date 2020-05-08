package com.phi.proyect.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.Divisas;




public interface DivisasRepository extends JpaRepository<Divisas,String> {
	
	
	/**
	 * Método para consultar las reservas por cliente
	 * 
	 * @param cliente
	 * @return
	 */
	//@Query("Select market_surcharge from vector_de_precios_historico v where v.tv =:divisa")
	//public List<Divisas> findByTv(String divisa);
	
	
	public List<Divisas> findFirstByTvOrderByDateDesc(String divisa);
	
	
	@Query(value="SELECT DistEst(:valorEnvi);", nativeQuery =  true)
	public float distEst(@Param("valorEnvi") Double valorEnvi);
	
	@Query(value="SELECT VaRCapFloor(:valorEnvi1,:valorEnvi2,:valorEnvi3,:valorEnvi4);", nativeQuery =  true)
	public float VaRCapFloor(@Param("valorEnvi1") String valorEnvi1,@Param("valorEnvi2") Integer valorEnvi2,@Param("valorEnvi3") Date valorEnvi3,@Param("valorEnvi4") Integer valorEnvi4);
	
	@Query(value="SELECT VaRFwdSwapStarting(:valorEnvi1,:valorEnvi2,:valorEnvi3);", nativeQuery =  true)
	public float VaRFwdSwapStarting(@Param("valorEnvi1") String valorEnvi1,@Param("valorEnvi2") Integer valorEnvi2,@Param("valorEnvi3") Date valorEnvi3);
	
	@Query(value="SELECT VaRSwapTIIE(:valorEnvi1,:valorEnvi2,:valorEnvi3);", nativeQuery =  true)
	public float VaRSwapTIIE(@Param("valorEnvi1") String valorEnvi1,@Param("valorEnvi2") Integer valorEnvi2,@Param("valorEnvi3") Date valorEnvi3);
	

}
