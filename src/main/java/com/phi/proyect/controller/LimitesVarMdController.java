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

import com.phi.proyect.models.LimitesMercado;
import com.phi.proyect.models.VarLimite;
import com.phi.proyect.service.LimiteMercado;
import com.phi.proyect.service.VarLimiteService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/limitesVarMd")
public class LimitesVarMdController {
	
	private final VarLimiteService vls;

	public LimitesVarMdController(VarLimiteService vls) {
		super();
		this.vls = vls;
	}
	
	@GetMapping(value = "/findAllVar")
	public List<VarLimite> listaVar() {
		List<VarLimite> lista = vls.findAllVar();
		return lista;
	}
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<VarLimite> createLimite(@RequestBody com.phi.proyect.vo.VarLimite varLimite) {
			VarLimite varLimiteCreate = new VarLimite();
			varLimiteCreate.setProducto(varLimite.getProducto());
			varLimiteCreate.setLimite(varLimite.getLimite());
			varLimiteCreate.setGlobalLimit(varLimite.getGlobalLimit());
			varLimiteCreate.setDirectOperationLimit(varLimite.getDirectOperationLimit());
			varLimiteCreate.setReportoOperationLimit(varLimite.getReportoOperationLimit());
			varLimiteCreate.setOperationLimitMoneyMarket(varLimite.getOperationLimitMoneyMarket());
			varLimiteCreate.setExchangeMarketLimit(varLimite.getExchangeMarketLimit());
			varLimiteCreate.setLimitOperationExchangeMarket(varLimite.getLimitOperationExchangeMarket());
			varLimiteCreate.setStatus(varLimite.getStatus());
			varLimiteCreate.setRegistrationDate(new Date());
			varLimiteCreate.setModificationDate(new Date());
			varLimiteCreate.setMarket(varLimite.getMarket());
			return new ResponseEntity<>(this.vls.create(varLimiteCreate), HttpStatus.CREATED);
	}
	
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<VarLimite> updateLimite(@PathVariable("id") int id,
			@RequestBody com.phi.proyect.vo.VarLimite varLimite) {
		VarLimite varLimite2 = vls.findByIdVarLimiteMd(id);
		if (varLimite2 != null) {
			varLimite2.setProducto(varLimite.getProducto());
			varLimite2.setLimite(varLimite.getLimite());
			varLimite2.setGlobalLimit(varLimite.getGlobalLimit());
			varLimite2.setDirectOperationLimit(varLimite.getDirectOperationLimit());
			varLimite2.setReportoOperationLimit(varLimite.getReportoOperationLimit());
			varLimite2.setOperationLimitMoneyMarket(varLimite.getOperationLimitMoneyMarket());
			varLimite2.setExchangeMarketLimit(varLimite.getExchangeMarketLimit());
			varLimite2.setLimitOperationExchangeMarket(varLimite.getLimitOperationExchangeMarket());
			varLimite2.setStatus(varLimite.getStatus());
			varLimite2.setRegistrationDate(new Date());
			varLimite2.setModificationDate(new Date());

			return new ResponseEntity<VarLimite>(this.vls.update(varLimite2), HttpStatus.OK);

		} else {
			return new ResponseEntity<VarLimite>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity delete(@PathVariable("id") int id) {
		VarLimite varLimite2 = vls.findByIdVarLimiteMd(id);
		if (varLimite2 != null) {
			vls.delete(varLimite2);
			return new ResponseEntity<VarLimite>(HttpStatus.OK);
		} else {
			return new ResponseEntity<VarLimite>(HttpStatus.NOT_FOUND);
		}
	}


}
