package com.phi.proyect.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		/*
		 * for (int i = 0; i < lista.size(); i++) {
		 * System.out.println(lista.get(i).getFecha_modificacion());
		 * System.out.println(lista.get(i).getId());
		 * 
		 * }
		 */
		//mav.addObject("data", lista);
		mav.addObject("titulo", "Limites y Lineas");
		mav.setViewName("limites");
		return mav;
	}
	
	@GetMapping(value = "lista")
	public List<LimitesLineas> lista() {
		List<LimitesLineas> lista = lls.findAll();
		return lista;
	} 

	@PostMapping(consumes = "application/json")
	public ResponseEntity<LimitesLineas> createLimite(@RequestBody com.phi.proyect.vo.LimitesLineas limitesLineas) {
		LimitesLineas limitesLineasOptional = lls.findByContraparte(limitesLineas.getContraparte());
		if (limitesLineasOptional != null) {
			return new ResponseEntity<LimitesLineas>(HttpStatus.FOUND);

			
		}else {
		
		
		LimitesLineas limitesLineas2 = new LimitesLineas();
		System.out.println(limitesLineas.getContraparte());
		limitesLineas2.setContraparte(limitesLineas.getContraparte());
		limitesLineas2.setGlobalLimit(limitesLineas.getGlobalLimit());
		limitesLineas2.setDirectOperationLimit(limitesLineas.getDirectOperationLimit());
		limitesLineas2.setReportoOperationLimit(limitesLineas.getReportoOperationLimit());
		limitesLineas2.setOperationLimitMoneyMarket(limitesLineas.getOperationLimitMoneyMarket());
		limitesLineas2.setExchangeMarketLimit(limitesLineas.getExchangeMarketLimit());
		limitesLineas2.setLimitOperationExchangeMarket(limitesLineas.getLimitOperationExchangeMarket());
		limitesLineas2.setMercado(limitesLineas.getMercado());
		limitesLineas2.setUsuario(limitesLineas.getUsuario());
		limitesLineas2.setEstatus(limitesLineas.getEstatus());
		limitesLineas2.setFechaModificacion(new Date());
		return new ResponseEntity<>(this.lls.create(limitesLineas2), HttpStatus.CREATED);

	}
	}

	@PutMapping(consumes = "application/json", value = "/{id}")
	public ResponseEntity<LimitesLineas> updateLimite(@PathVariable("id") String contraparte,
			@RequestBody com.phi.proyect.vo.LimitesLineas limitesLineas) {
		LimitesLineas limitesLineasOptional = lls.findByContraparte(contraparte);
		if (limitesLineasOptional != null) {
		//	LimitesLineas limitesLineas2 = limitesLineasOptional.get();
			limitesLineasOptional.setContraparte(limitesLineas.getContraparte());
			limitesLineasOptional.setGlobalLimit(limitesLineas.getGlobalLimit());
			limitesLineasOptional.setDirectOperationLimit(limitesLineas.getDirectOperationLimit());
			limitesLineasOptional.setReportoOperationLimit(limitesLineas.getReportoOperationLimit());
			limitesLineasOptional.setOperationLimitMoneyMarket(limitesLineas.getOperationLimitMoneyMarket());
			limitesLineasOptional.setExchangeMarketLimit(limitesLineas.getExchangeMarketLimit());
			limitesLineasOptional.setLimitOperationExchangeMarket(limitesLineas.getLimitOperationExchangeMarket());
			limitesLineasOptional.setMercado(limitesLineas.getMercado());
			limitesLineasOptional.setUsuario(limitesLineas.getUsuario());
			limitesLineasOptional.setFechaModificacion(new Date());
			return new ResponseEntity<LimitesLineas>(this.lls.update(limitesLineasOptional), HttpStatus.OK);
		} else {
			return new ResponseEntity<LimitesLineas>(HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity delete(@PathVariable("id") String contraparte) {
		LimitesLineas limitesLineasOptional = lls.findByContraparte(contraparte);
		if (limitesLineasOptional != null) {
			lls.delete(limitesLineasOptional);
			return new ResponseEntity<LimitesLineas>(HttpStatus.OK);
		}else {
			return new ResponseEntity<LimitesLineas>(HttpStatus.NOT_FOUND);
		}
	}
}
