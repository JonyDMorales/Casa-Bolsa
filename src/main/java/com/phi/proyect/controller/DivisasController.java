package com.phi.proyect.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.phi.proyect.models.Divisas;
import com.phi.proyect.service.DivisasService;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/divisas")
public class DivisasController {
	
	
	
	
	private final DivisasService dvs;
	
	
	public DivisasController(DivisasService dvs) {
		super();
		this.dvs = dvs;
	}


	
	
	@GetMapping(value = "listadv/{divisa}")
	public List<Divisas> lista(@PathVariable("divisa") String divisa) {
		List<Divisas> lista = dvs.findFirstByTvOrderByDateDesc(divisa);
		//List<Divisas> lista = dvs.findAll("LS");
		return lista;
	}


}
