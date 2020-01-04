package com.phi.proyect.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.service.LimitesLineasService;

@RestController
@RequestMapping("/limiteslineas")
public class LimitesLineasController {
	
	
	private final LimitesLineasService lls;

	public LimitesLineasController(LimitesLineasService lls) {
		super();
		this.lls = lls;
	}
	
	
	@GetMapping
	public ModelAndView findAll() {
		  ModelAndView mav = new ModelAndView();

		  List<LimitesLineas> lista = lls.findAll();
		  /*for (int i = 0; i < lista.size(); i++) {
			  System.out.println(lista.get(i).getFecha_modificacion());
			  System.out.println(lista.get(i).getId());

			}*/
	        mav.addObject("data", lista);
	        mav.addObject("titulo", "Limites");
	        mav.setViewName("limites");
	      return mav;
		
		
	}
	
	
	
}
