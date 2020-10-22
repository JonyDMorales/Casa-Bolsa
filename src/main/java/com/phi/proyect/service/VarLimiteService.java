package com.phi.proyect.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.LimitesMercado;
import com.phi.proyect.models.VarLimite;
import com.phi.proyect.repository.VarLimiteRepository;

@Service
@Transactional(readOnly = true)
public class VarLimiteService {

	@Autowired
	private VarLimiteRepository varlir;
	
	public List<VarLimite> findAll(String producto) {
		List<VarLimite> listVarLimite = varlir.findByProducto(producto);

		if(listVarLimite == null || listVarLimite.isEmpty()){
			return new ArrayList<>();
		}

		return listVarLimite;
		
	}
		
	public List<VarLimite> findAllVar() {
		return varlir.findAll();
	}	
	
	@Transactional
	public VarLimite findByIdVarLimiteMd(int idVarLimite) {
		return varlir.findByIdVarLimiteMd(idVarLimite);
	}

	@Transactional
	public VarLimite create(VarLimite limite) {
		return this.varlir.save(limite);

	}

	@Transactional
	public VarLimite update(VarLimite limite) {
		return this.varlir.save(limite);
	}

	

	@Transactional
	public void delete(VarLimite limite) {
		this.varlir.delete(limite);
	}
	
}
