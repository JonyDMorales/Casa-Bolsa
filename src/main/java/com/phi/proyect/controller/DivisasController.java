package com.phi.proyect.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phi.proyect.models.Divisas;
import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.service.DivisasService;
import com.phi.proyect.service.LimitesLineasService;


@RestController
@RequestMapping("/divisas")
public class DivisasController {
	
	
	
	
	private final DivisasService dvs;
	
	
	public DivisasController(DivisasService dvs) {
		super();
		this.dvs = dvs;
	}


	
	
	@GetMapping(value = "listadv")
	public List<Divisas> lista() {
		List<Divisas> lista = dvs.findByTv("LS");
		return lista;
	} 


}
