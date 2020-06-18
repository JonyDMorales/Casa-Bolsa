package com.phi.proyect.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.phi.proyect.models.LimitesMercado;
import com.phi.proyect.models.VarLimite;
import com.phi.proyect.models.VarOperacionesMd;
import com.phi.proyect.service.LimiteMercado;
import com.phi.proyect.service.VarLimiteService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/limitesMercado")
public class LimitesMercadoController {

	private final LimiteMercado lm;
	private final VarLimiteService vls;

	public LimitesMercadoController(LimiteMercado lm,VarLimiteService vls) {
		super();
		this.lm = lm;
		this.vls = vls;
	}
	
	
	@GetMapping(value= "/findAll")
	public List<LimitesMercado> lista() {
		List<LimitesMercado> lista = lm.findAll();
		return lista;
	}
	
	@GetMapping(value= "/findAllVar")
	public List<VarLimite> listaVar() {
		List<VarLimite> lista = vls.findAllVar();
		return lista;
	}
	
}
