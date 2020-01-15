package com.phi.proyect.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.service.LimitesLineasService;

@RestController
@RequestMapping("/semaforosalertas")
public class ContraparteController {

	private final LimitesLineasService lls;
	
	public ContraparteController(LimitesLineasService lls) {
		super();
		this.lls = lls;
	}
	
	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView();
		
		
		mav.addObject("titulo", "Semaforos y Alertas");
		mav.setViewName("semaforosalertas");
		return mav;
	}
	@GetMapping(value = "lista")
	public List<LimitesLineas> lista() {
		List<LimitesLineas> lista = lls.findAll();
		return lista;
	} 
	
}
