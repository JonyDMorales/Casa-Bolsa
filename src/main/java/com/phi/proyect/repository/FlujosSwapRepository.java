package com.phi.proyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.FlujosSwap;

public interface FlujosSwapRepository extends JpaRepository<FlujosSwap, Integer>{
	
	@Modifying
	@Query(value="INSERT INTO flujos_swap (Cd_Transaccion,Nu_Pago,Fh_Pago,Nu_Monto_Pago,Nu_PlazoCupon,Nu_TasaVigente,Cd_Activo) VALUES( :transaccion, :nPago, :fPago, :monto, :plazo, :tasa, :activo)", nativeQuery =  true)
	int save2(@Param("transaccion") String transaccion,@Param("nPago") int nPago,@Param("fPago") String fPago,@Param("monto") Double monto,@Param("plazo") int plazo, @Param("tasa") Double tasa, @Param("activo") int activo);

}
