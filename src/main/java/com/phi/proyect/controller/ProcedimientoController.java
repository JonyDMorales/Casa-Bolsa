package com.phi.proyect.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.phi.proyect.service.DivisasService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/procedimiento")
public class ProcedimientoController {
	
	private final DivisasService dvs;
	
	 public ProcedimientoController(DivisasService dvs) {
		super();
		this.dvs=dvs;
	}
	
	@GetMapping("/DistEst/{valor}")
	public float ejecutarProcedure(@PathVariable("valor") double valor) {
		float retornoValor = dvs.distEst(valor);
		return retornoValor;
	}
	
	
	@PostMapping("/VaRCapFloor")
	public double VaRCapFloor(@RequestBody ObjectNode obj) {
		String CdTransaccion = obj.get("CdTransaccion").asText();
		Integer CdCurva = obj.get("CdCurva").asInt();
		String fecha = obj.get("LdFecha").asText();
		Date LdFecha = null;
		Integer CdCDescuento = obj.get("CdCDescuento").asInt();
		try {
			 LdFecha = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		} catch (ParseException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		double retornoValor = dvs.VaRCapFloor(CdTransaccion, CdCurva, LdFecha, CdCDescuento);
		return retornoValor;
	}
	
	@PostMapping("/VaRFwdSwapStarting")
	public double VaRFwdSwapStarting(@RequestBody ObjectNode obj) {
		
		String CdTransaccion = obj.get("CdTransaccion").asText();
		Integer CdCurva = obj.get("CdCurva").asInt();
		String fecha = obj.get("LdFecha").asText();
		Date LdFecha = null;
		try {
			 LdFecha = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		} catch (ParseException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		double retornoValor = dvs.VaRFwdSwapStarting(CdTransaccion, CdCurva, LdFecha);
		return retornoValor;
	}
	
	@PostMapping("/VaRSwapTIIE")
	public double VaRSwapTIIE(@RequestBody ObjectNode obj) {
		
		String CdTransaccion = obj.get("CdTransaccion").asText();
		Integer CdCurva = obj.get("CdCurva").asInt();
		String fecha = obj.get("LdFecha").asText();
		Date LdFecha = null;
		try {
			 LdFecha = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		} catch (ParseException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		double retornoValor = dvs.VaRSwapTIIE(CdTransaccion, CdCurva, LdFecha);
		return retornoValor;
	}

}
