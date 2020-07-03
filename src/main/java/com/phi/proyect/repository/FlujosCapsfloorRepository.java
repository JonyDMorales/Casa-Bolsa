package com.phi.proyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.FlujosCapsfloor;

public interface FlujosCapsfloorRepository extends JpaRepository<FlujosCapsfloor, Integer>{
	
	@Modifying
	@Query(value="INSERT INTO flujos_capsfloor (Cd_Transaccion,Nu_Pago,Fh_Pago,Nu_Monto_Pago,Nu_PlazoCupon,Nu_TasaVigente,Cd_Activo) VALUES( :transaccion, :nuPago, :fhPago, :monto, :plazo, :tasa, :activo)", nativeQuery =  true)
	int save2(@Param("transaccion") String transaccion,@Param("nuPago") int nuPago,@Param("fhPago") String fhPago,@Param("monto") Double monto,@Param("plazo") int plazo, @Param("tasa") Double tasa, @Param("activo") int activo);

}
