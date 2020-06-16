package com.phi.proyect.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phi.proyect.service.LimiteMercado;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/limitesMercado")
public class LimitesMercadoController {

	private final LimiteMercado lm;

	public LimitesMercadoController(LimiteMercado lm) {
		super();
		this.lm = lm;
	}
}
