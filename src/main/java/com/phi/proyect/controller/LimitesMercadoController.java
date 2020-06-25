package com.phi.proyect.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.LimitesMercado;
import com.phi.proyect.models.VarLimite;
import com.phi.proyect.service.LimiteMercado;
import com.phi.proyect.service.VarLimiteService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/limitesMercado")
public class LimitesMercadoController {

	private final LimiteMercado lm;
	private final VarLimiteService vls;

	public LimitesMercadoController(LimiteMercado lm, VarLimiteService vls) {
		super();
		this.lm = lm;
		this.vls = vls;
	}

	@GetMapping(value = "/findAll")
	public List<LimitesMercado> lista() {
		List<LimitesMercado> lista = lm.findAll();
		return lista;
	}

	@GetMapping(value = "/findAllVar")
	public List<VarLimite> listaVar() {
		List<VarLimite> lista = vls.findAllVar();
		return lista;
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<LimitesMercado> createLimite(@RequestBody com.phi.proyect.vo.LimitesMercado limitesMercado) {
		LimitesMercado limitesMercado2 = lm.findByMercado(limitesMercado.getMercado());
		if (limitesMercado2 != null) {

			limitesMercado2.setMercado(limitesMercado.getMercado());
			limitesMercado2.setGlobalLimit(limitesMercado.getGlobalLimit());
			limitesMercado2.setDirectOperationLimit(limitesMercado.getDirectOperationLimit());
			limitesMercado2.setReportoOperationLimit(limitesMercado.getReportoOperationLimit());
			limitesMercado2.setOperationLimitMoneyMarket(limitesMercado.getOperationLimitMoneyMarket());
			limitesMercado2.setExchangeMarketLimit(limitesMercado.getExchangeMarketLimit());
			limitesMercado2.setLimitOperationExchangeMarket(limitesMercado.getLimitOperationExchangeMarket());
			limitesMercado2.setStatus(limitesMercado.getStatus());
			limitesMercado2.setRegistrationDate(limitesMercado.getRegistrationDate());
			limitesMercado2.setModificationDate(limitesMercado.getModificationDate());
			return new ResponseEntity<LimitesMercado>(this.lm.update(limitesMercado2), HttpStatus.OK);

		} else {

			LimitesMercado limitesMercadoCreate = new LimitesMercado();
			limitesMercadoCreate.setMercado(limitesMercado.getMercado());
			limitesMercadoCreate.setGlobalLimit(limitesMercado.getGlobalLimit());
			limitesMercadoCreate.setDirectOperationLimit(limitesMercado.getDirectOperationLimit());
			limitesMercadoCreate.setReportoOperationLimit(limitesMercado.getReportoOperationLimit());
			limitesMercadoCreate.setOperationLimitMoneyMarket(limitesMercado.getOperationLimitMoneyMarket());
			limitesMercadoCreate.setExchangeMarketLimit(limitesMercado.getExchangeMarketLimit());
			limitesMercadoCreate.setLimitOperationExchangeMarket(limitesMercado.getLimitOperationExchangeMarket());
			limitesMercadoCreate.setStatus(limitesMercado.getStatus());
			limitesMercadoCreate.setRegistrationDate(limitesMercado.getRegistrationDate());
			limitesMercadoCreate.setModificationDate(limitesMercado.getModificationDate());
			return new ResponseEntity<>(this.lm.create(limitesMercadoCreate), HttpStatus.CREATED);

		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<LimitesMercado> updateLimite(@PathVariable("id") String contraparte,
			@RequestBody com.phi.proyect.vo.LimitesMercado limitesMercado) {
		LimitesMercado limitesMercado2 = lm.findByMercado(limitesMercado.getMercado());
		if (limitesMercado2 != null) {

			limitesMercado2.setMercado(limitesMercado.getMercado());
			limitesMercado2.setGlobalLimit(limitesMercado.getGlobalLimit());
			limitesMercado2.setDirectOperationLimit(limitesMercado.getDirectOperationLimit());
			limitesMercado2.setReportoOperationLimit(limitesMercado.getReportoOperationLimit());
			limitesMercado2.setOperationLimitMoneyMarket(limitesMercado.getOperationLimitMoneyMarket());
			limitesMercado2.setExchangeMarketLimit(limitesMercado.getExchangeMarketLimit());
			limitesMercado2.setLimitOperationExchangeMarket(limitesMercado.getLimitOperationExchangeMarket());
			limitesMercado2.setStatus(limitesMercado.getStatus());
			limitesMercado2.setRegistrationDate(limitesMercado.getRegistrationDate());
			limitesMercado2.setModificationDate(limitesMercado.getModificationDate());
			return new ResponseEntity<LimitesMercado>(this.lm.update(limitesMercado2), HttpStatus.OK);
		} else {
			return new ResponseEntity<LimitesMercado>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity delete(@PathVariable("id") String mercado) {
		LimitesMercado limitesMercado = lm.findByMercado(mercado);
		if (limitesMercado != null) {
			lm.delete(limitesMercado);
			return new ResponseEntity<LimiteMercado>(HttpStatus.OK);
		} else {
			return new ResponseEntity<LimiteMercado>(HttpStatus.NOT_FOUND);
		}
	}

}
