package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.DeSwap;
import com.phi.proyect.models.LimitesMercado;

public interface DeSwapRepository extends JpaRepository<DeSwap, Integer>{
	
	
	
	@Query(value="SELECT Cd_Transaccion,Cd_Instrumento,Fh_Inicio,Fh_Fin,Nu_Curva_Descuento,Nu_Curva_Desc_Flot,Nu_Fija,Nu_Flotante,Nu_Nominal,Tc_Banco,Tc_Cliente,Cd_Bco_Recibe,Nu_Convencion,Tp_Producto,Tp_Transaccion,Tp_Descuento FROM de_swap where Cd_Transaccion =:id limit 1", nativeQuery =  true)
	public List<DeSwap> findByTransaccion(@Param("id") String id);
	
	@Modifying
	@Query(value="INSERT INTO de_swap (Cd_Transaccion,Cd_Instrumento,Fh_Inicio,Fh_Fin,Nu_Curva_Descuento,Nu_Curva_Desc_Flot,Nu_Fija,Nu_Flotante,Nu_Nominal,Tc_Banco,Tc_Cliente,Cd_Bco_Recibe,Nu_Convencion,Tp_Producto,Tp_Transaccion,Tp_Descuento) VALUES( :transaccion, :intrumento, :inicio, :fin, :curva, :curvaDescFlot, :fija, :flotante, :nominal, :banco, :cliente, :recibe, :convencion, :tpProducto, :tpTransaccion, :tpEstandar)", nativeQuery =  true)
	int save2(@Param("transaccion") String transaccion,@Param("intrumento") int intrumento,@Param("inicio") String inicio,@Param("fin") String fin,@Param("curva") int curva,@Param("curvaDescFlot") int curvaDescFlot, @Param("fija") Double fija, @Param("flotante") int flotante,@Param("nominal") int nominal,@Param("banco") Double banco,@Param("cliente") Double cliente,@Param("recibe") int recibe,@Param("convencion") Double convencion, @Param("tpProducto") int tpProducto, @Param("tpTransaccion") int tpTransaccion ,@Param("tpEstandar") int tpEstandar);

}
