package com.phi.proyect.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phi.proyect.models.VarOperacionesMd;

public interface VarOperacionesMdRepository  extends JpaRepository<VarOperacionesMd, Integer> {

	public List<VarOperacionesMd> findByFecha(String fecha);
	
	
	public List<VarOperacionesMd> findByFechaAndInstrumento(String fecha,String producto);
	
}
