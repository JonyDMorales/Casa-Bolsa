package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.CdInstrumento;
import com.phi.proyect.models.DeCapsfloor;

public interface DeCapsfloorRepository extends JpaRepository<DeCapsfloor, Integer>{
	
	@Modifying
	@Query(value="INSERT INTO de_capsfloor (Cd_Transaccion,Cd_Instrumento,Fh_Inicio,Fh_Fin,Nu_Curva_Descuento,Nu_Curva_Volatilidad,Nu_Strike,Tc,Nu_Nominal,Nu_Convencion) VALUES( :transaccion, :instrumento, :fechaInicio, :fechaFin, :curvaDes, :curvaVola, :strike, :tc, :nominal, :convencion)", nativeQuery =  true)
	int save2(@Param("transaccion") String transaccion,@Param("instrumento") int instrumento,@Param("fechaInicio") String fechaInicio,@Param("fechaFin") String fechaFin,@Param("curvaDes") int curvaDes, @Param("curvaVola") int curvaVola, @Param("strike") Double strike, @Param("tc") Double tc, @Param("nominal") int nominal, @Param("convencion") int convencion );

	@Query(value="SELECT * FROM de_capsfloor where Cd_Transaccion =:id limit 1", nativeQuery =  true)
	public List<DeCapsfloor> findByCdTransaccion(@Param("id") String id);
}
