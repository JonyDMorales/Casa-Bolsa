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
		mav.addObject("data", lista);
		mav.addObject("titulo", "Limites");
		mav.setViewName("limites");
		return mav;
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<LimitesLineas> createLimite(@RequestBody com.phi.proyect.vo.LimitesLineas limitesLineas) {
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
		limitesLineas2.setEstatus(0);
		limitesLineas2.setFechaModificacion(new Date());
		return new ResponseEntity<>(this.lls.create(limitesLineas2), HttpStatus.CREATED);
	}

	@PutMapping(consumes = "application/json", value = "/{id}")
	public ResponseEntity<LimitesLineas> updateLimite(@PathVariable("id") Integer id,
			@RequestBody com.phi.proyect.vo.LimitesLineas limitesLineas) {
		Optional<LimitesLineas> limitesLineasOptional = lls.findById(id);
		if (limitesLineasOptional.isPresent()) {
			LimitesLineas limitesLineas2 = limitesLineasOptional.get();
			limitesLineas2.setContraparte(limitesLineas.getContraparte());
			limitesLineas2.setGlobalLimit(limitesLineas.getGlobalLimit());
			limitesLineas2.setDirectOperationLimit(limitesLineas.getDirectOperationLimit());
			limitesLineas2.setReportoOperationLimit(limitesLineas.getReportoOperationLimit());
			limitesLineas2.setOperationLimitMoneyMarket(limitesLineas.getOperationLimitMoneyMarket());
			limitesLineas2.setExchangeMarketLimit(limitesLineas.getExchangeMarketLimit());
			limitesLineas2.setLimitOperationExchangeMarket(limitesLineas.getLimitOperationExchangeMarket());
			limitesLineas2.setMercado(limitesLineas.getMercado());
			limitesLineas2.setUsuario(limitesLineas.getUsuario());
			limitesLineas2.setFechaModificacion(new Date());
			return new ResponseEntity<LimitesLineas>(this.lls.update(limitesLineas2), HttpStatus.OK);
		} else {
			return new ResponseEntity<LimitesLineas>(HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity delete(@PathVariable("id") Integer id) {
		Optional<LimitesLineas> limitesLineasOptional = lls.findById(id);
		if (limitesLineasOptional.isPresent()) {
			lls.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<LimitesLineas>(HttpStatus.NOT_FOUND);
		}
	}
}
