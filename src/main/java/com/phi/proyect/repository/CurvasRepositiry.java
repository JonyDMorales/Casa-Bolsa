package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.Curvas;

public interface CurvasRepositiry extends JpaRepository<Curvas, Integer> {
	@Modifying
	@Query(value="INSERT INTO h_curvas (Cd_Curva,Fh_Date,N1,N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, N21, N22, N23, N24, N25, N26, N27, N28) VALUES( :curva, :fecha, :p1, :p2, :p3, :p4, :p5, :p6, :p7, :p8, :p9, :p10, :p11, :p12, :p13, :p14, :p15, :p16, :p17, :p18, :p19, :p20, :p21, :p22, :p23, :p24, :p25, :p26, :p27, :p28)", nativeQuery =  true)
	int save2(@Param("curva") int curva,@Param("fecha") String fecha,@Param("p1") double p1,@Param("p2") double p2,@Param("p3") double p3,@Param("p4") double p4, @Param("p5") double p5,@Param("p6") double p6,@Param("p7") double p7,@Param("p8") double p8,@Param("p9") double p9,@Param("p10") double p10,@Param("p11") double p11,@Param("p12") double p12,@Param("p13") double p13,@Param("p14") double p14,@Param("p15") double p15,@Param("p16") double p16,@Param("p17") double p17,@Param("p18") double p18,@Param("p19") double p19,@Param("p20") double p20,@Param("p21") double p21,@Param("p22") double p22,@Param("p23") double p23,@Param("p24") double p24,@Param("p25") double p25,@Param("p26") double p26,@Param("p27") double p27,@Param("p28") double p28);
}
