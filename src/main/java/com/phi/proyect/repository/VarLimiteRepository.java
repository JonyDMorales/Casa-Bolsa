package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.LimitesMercado;
import com.phi.proyect.models.OperacionesMd;
import com.phi.proyect.models.VarLimite;

public interface VarLimiteRepository extends JpaRepository<VarLimite, Integer>{

	public List<VarLimite> findByProducto(String producto);
	
	public List<VarLimite> findAll();
	
	public VarLimite findByIdVarLimiteMd(int idVarLimite);
	
}
