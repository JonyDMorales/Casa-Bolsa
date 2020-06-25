package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.VarLimite;
import com.phi.proyect.repository.VarLimiteRepository;

@Service
@Transactional(readOnly = true)
public class VarLimiteService {

	@Autowired
	private VarLimiteRepository varlir;
	
	public List<VarLimite> findAll(String producto) {
		return varlir.findByProducto(producto);
		
	}
		
	public List<VarLimite> findAllVar() {
		return varlir.findAll();
	}	

}
