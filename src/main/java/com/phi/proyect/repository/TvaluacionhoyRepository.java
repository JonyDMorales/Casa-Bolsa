package com.phi.proyect.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.Tvaluacionhoy;

public interface TvaluacionhoyRepository extends JpaRepository<Tvaluacionhoy,Integer>{

	@Modifying
	@Query(value="INSERT INTO tvaluacionhoy (Cd_Transaccion,Valuacion,cd_instrumento,fecha,var1,var2,var3,portafolio) VALUES(:cd, :valuacion,:instrumento,:fecha,:var1,:var2,:var3,:portafolio)", nativeQuery =  true)
	int save2(@Param("cd") String cd,@Param("valuacion") double valuacion,@Param("instrumento") int instrumento,@Param("fecha") String fecha, @Param("var1") double var1, @Param("var2") double var2, @Param("var3") double var3,@Param("portafolio") Integer portafolio);

	@Modifying
	@Query(value="UPDATE tvaluacionhoy SET var1 = :var1, var2 = :var2, var3 = :var3 WHERE Cd_Transaccion = :cd AND fecha = :fecha", nativeQuery =  true)
	void actualizarRegistro(@Param("cd") String cd,@Param("fecha") String fecha, @Param("var1") double var1, @Param("var2") double var2, @Param("var3") double var3);

	@Modifying
	@Query(value="INSERT INTO tvaluacionhistorico (Cd_Transaccion,Valuacion,cd_instrumento,var1,var2,var3,portafolio,fecha) VALUES(:cd, :valuacion,:instrumento,:var1,:var2,:var3,:portafolio,:fecha)", nativeQuery =  true)
	int save3(@Param("cd") String cd,@Param("valuacion") double valuacion,@Param("instrumento") int instrumento, @Param("var1") double var1, @Param("var2") double var2, @Param("var3") double var3,@Param("portafolio") Integer portafolio,@Param("fecha") String fecha);
	
	@Query(value="select * from tvaluacionhoy WHERE cd_instrumento = :cdInstrumento AND fecha = :fecha", nativeQuery =  true)
	public List<Tvaluacionhoy> findBycdInstrumento(@Param("cdInstrumento") String cdInstrumento, @Param("fecha") String fecha);
	
	@Query(value="select * from tvaluacionhistorico WHERE Cd_Transaccion =:cd AND fecha =:fecha", nativeQuery =  true)
	public List<Tvaluacionhoy> findByInsertHistorico(@Param("cd") String cd, @Param("fecha") String fecha);
	
	@Query(value="select * from tvaluacionhistorico WHERE Cd_Transaccion =:cd", nativeQuery =  true)
	public List<Tvaluacionhoy> findByCdTransa(@Param("cd") String cd);
}
