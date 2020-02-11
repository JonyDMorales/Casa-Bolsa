package com.phi.proyect.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.Logaritmo;
import com.phi.proyect.models.Vector;
import com.phi.proyect.service.LogaritmoService;
import com.phi.proyect.service.VectorService;


@RestController
@RequestMapping("/logaritmo")
public class LogaritmoController {

	private final LogaritmoService log;
	private final VectorService vecSer;
	
	
	public LogaritmoController(LogaritmoService log,VectorService vecSer) {
		super();
		this.log = log;
		this.vecSer = vecSer;
	}


	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("titulo", "Logaritmo");
		mav.setViewName("logaritmo");
		//lista("IM_BPAG28_191121");
		return mav;
	}
	
	
	@GetMapping(consumes = "application/json", value = "getParametros/{logaritmo}")
	public List<com.phi.proyect.vo.Logaritmo> lista(@PathVariable("logaritmo") String descripcion) {
		List<Logaritmo> lista = log.findByDescripcion(descripcion);
		List<Vector> lista2 = vecSer.findIssue(lista.get(0).getDescripcion(),Integer.parseInt(lista.get(0).getValorDelParametro()));
		List<com.phi.proyect.vo.Logaritmo> listReturn = new ArrayList<com.phi.proyect.vo.Logaritmo>();
		int cont =1;
		for (int i = 0; i < lista2.size()-1; i++) {
				Float logaritmo = (float) 0.0;
				logaritmo = (float) Math.log(lista2.get(i).getMarketSurcharge()/lista2.get(cont).getMarketSurcharge());
				listReturn.add(new com.phi.proyect.vo.Logaritmo(logaritmo));
				cont++;
		}
		
		return listReturn;
	} 
	
}
