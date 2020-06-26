package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.LimitesMercado;
import com.phi.proyect.models.VarLimite;
import com.phi.proyect.repository.LimitesMercadoRepository;

@Service
@Transactional(readOnly = true)
public class LimiteMercado {

	@Autowired
	private LimitesMercadoRepository lmr;

	public List<LimitesMercado> findAll() {
		return lmr.findAll();
	}

	@Transactional
	public LimitesMercado findByMercado(String mercado) {
		return lmr.findByMercado(mercado);
	}
	
	@Transactional
	public LimitesMercado create(LimitesMercado limitesMercado) {
		return this.lmr.save(limitesMercado);

	}

	@Transactional
	public LimitesMercado update(LimitesMercado limitesMercado) {
		return this.lmr.save(limitesMercado);
	}

	

	@Transactional
	public void delete(LimitesMercado limitesMercado) {
		this.lmr.delete(limitesMercado);
	}
}
