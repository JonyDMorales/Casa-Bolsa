package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.CdInstrumento;

public interface CdInstrumentoRepository extends JpaRepository<CdInstrumento, Integer>{

	@Query(value="SELECT * FROM cd_instrumento where ID_Instrumento =:id limit 1", nativeQuery =  true)
	public List<CdInstrumento> findByFkIdInstrumento(@Param("id") int id);
}
