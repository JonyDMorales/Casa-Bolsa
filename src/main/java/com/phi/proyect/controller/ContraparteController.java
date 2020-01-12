package com.phi.proyect.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.service.LimitesLineasService;

@RestController
@RequestMapping("/contraparte")
public class ContraparteController {

	private final LimitesLineasService lls;
	
	public ContraparteController(LimitesLineasService lls) {
		super();
		this.lls = lls;
	}
	
	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView();
		
		List<LimitesLineas> lista = lls.findAll();
		for (int i = 0; i < lista.size(); i++) {
		  //System.out.println(lista.get(i).getId());
		  //Float suma = lista.get(i).getGlobalLimit() - lista.get(i)

		}
		return mav;
	}
	
}
