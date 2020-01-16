package com.phi.proyect.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.phi.proyect.models.Divisas;
import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.OperacionesMd;
import com.phi.proyect.service.LimitesLineasService;
import com.phi.proyect.service.OperacionService;

@RestController
@RequestMapping("/semaforosalertas")
public class ContraparteController {

	private final LimitesLineasService lls;
	private final OperacionService ops;
	
	public ContraparteController(LimitesLineasService lls,OperacionService ops) {
		super();
		this.lls = lls;
		this.ops = ops;
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
	
	
	@GetMapping(value = "limiteUtilizado/{contraparte}")
	public List<OperacionesMd> limiteUtilizado(@PathVariable("contraparte") String contraparte) {
		
		
		List<OperacionesMd> lista = ops.findAll();

		return lista;
	} 
}
