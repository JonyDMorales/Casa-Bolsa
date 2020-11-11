package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.Curvas;
import com.phi.proyect.models.FlujosSwap;

public interface FlujosSwapRepository extends JpaRepository<FlujosSwap, Integer>{
	
	@Modifying
	@Query(value="INSERT INTO flujos_swap (Cd_Transaccion,Nu_Pago,Fh_Pago,Nu_Monto_Pago,Nu_PlazoCupon,Nu_TasaVigente,Cd_Activo,Fh_Pago_B,Nu_Monto_Pago_B,Nu_PlazoCupon_B) VALUES( :transaccion, :nPago, :fPago, :monto, :plazo, :tasa, :activo, :fPagoB, :nuMontoPagoB, :nuPlazoCuponB)", nativeQuery =  true)
	int save2(@Param("transaccion") String transaccion,@Param("nPago") int nPago,@Param("fPago") String fPago,@Param("monto") Double monto,@Param("plazo") int plazo, @Param("tasa") Double tasa, @Param("activo") int activo, @Param("fPagoB") String fPagoB, @Param("nuMontoPagoB") Double nuMontoPagoB, @Param("nuPlazoCuponB") int nuPlazoCuponB);
	
	@Query(value="SELECT * FROM flujos_swap group by Cd_Transaccion;", nativeQuery =  true)
	public List<FlujosSwap> getRegistros();
	
	@Modifying
	@Query(value="delete from flujos_swap", nativeQuery =  true)
	int deleteAllFlujos();
	


}
