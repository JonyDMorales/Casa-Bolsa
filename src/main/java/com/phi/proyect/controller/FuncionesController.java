package com.phi.proyect.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.phi.proyect.service.FuncionesService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/funciones")
public class FuncionesController {
	
	private final FuncionesService fs;
	
	public FuncionesController(FuncionesService fs) {
		super();
		this.fs=fs;
	}
	
	
	@PostMapping("/getfechaanterior")
	public Date getfechaanterior(@RequestBody ObjectNode obj) {
		
		Integer dias = obj.get("dias").asInt();
		//no regresa el mismo resultado por spring que haciendo la conslta directo(le aumenta un dia)
	
		String fecha = obj.get("fecha").asText();
		Date fechaFormated = null;
		
		try {
			fechaFormated = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		} catch (ParseException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		Date valorRetorno = fs.getfechaanterior(fechaFormated, dias);
		return valorRetorno;
	}
	
	@PostMapping("/ValFuDivisas")
	public double ValFuDivisas(@RequestBody ObjectNode obj) {

		String CdTransaccion = obj.get("CdTransaccion").asText();
		Integer CdCurva = obj.get("CdCurva").asInt();
		String LdFecha = obj.get("LdFecha").asText();
		Date fechaFormated = null;
		Integer CdIndice = obj.get("CdIndice").asInt();
		Integer CdCurvaFor = obj.get("CdCurvaFor").asInt();
		
		try {
			fechaFormated = new SimpleDateFormat("yyyy-MM-dd").parse(LdFecha);
		} catch (ParseException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		double valorRetorno = fs.ValFuDivisas(CdTransaccion, CdCurva, fechaFormated, CdIndice, CdCurvaFor);
		return valorRetorno;
	}
	
	
	@PostMapping("/ValFuIndices")
	public double ValFuIndices(@RequestBody ObjectNode obj) {

		String CdTransaccion = obj.get("CdTransaccion").asText();
		Integer CdCurva = obj.get("CdCurva").asInt();
		String LdFecha = obj.get("LdFecha").asText();
		Date fechaFormated = null;
		Integer CdIndice = obj.get("CdIndice").asInt();

		
		try {
			fechaFormated = new SimpleDateFormat("yyyy-MM-dd").parse(LdFecha);
		} catch (ParseException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		double valorRetorno = fs.ValFuIndices(CdTransaccion, CdCurva, fechaFormated, CdIndice);
		return valorRetorno;
	}
	
	
	@PostMapping("/ValFuTasas")
	public double ValFuTasas(@RequestBody ObjectNode obj) {

		String CdTransaccion = obj.get("CdTransaccion").asText();
		Integer CdCurva = obj.get("CdCurva").asInt();
		String LdFecha = obj.get("LdFecha").asText();
		Date fechaFormated = null;

		
		try {
			fechaFormated = new SimpleDateFormat("yyyy-MM-dd").parse(LdFecha);
		} catch (ParseException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		double valorRetorno = fs.ValFuTasas(CdTransaccion, CdCurva, fechaFormated);
		return valorRetorno;
	}
	
	
	@PostMapping("/ValSwapStarting")
	public double ValSwapStarting(@RequestBody ObjectNode obj) {

		String CdTransaccion = obj.get("CdTransaccion").asText();
		Integer CdCurva = obj.get("CdCurva").asInt();
		String LdFecha = obj.get("LdFecha").asText();
		Date fechaFormated = null;

		
		try {
			fechaFormated = new SimpleDateFormat("yyyy-MM-dd").parse(LdFecha);
		} catch (ParseException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		double valorRetorno = fs.ValSwapStarting(CdTransaccion, CdCurva, fechaFormated);
		return valorRetorno;
	}
	
	@PostMapping("/ValSwapTiie")
	public double ValSwapTiie(@RequestBody ObjectNode obj) {

		String CdTransaccion = obj.get("CdTransaccion").asText();
		int CdCurva = obj.get("CdCurva").asInt();
		String LdFecha = obj.get("LdFecha").asText();
		Date fechaFormated = null;
		int CdDescuento = obj.get("CdDescuento").asInt();

		
		try {
			fechaFormated = new SimpleDateFormat("yyyy-MM-dd").parse(LdFecha);
		} catch (ParseException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		//double valorRetorno = fs.ValSwapTiie(CdTransaccion, CdCurva, fechaFormated,CdDescuento);
		double valorRetorno = 0.0;
		return valorRetorno;
	}
	
	@PostMapping("/VaRFuDivisas")
	public double VaRFuDivisas(@RequestBody ObjectNode obj) {

		String CdTransaccion = obj.get("CdTransaccion").asText();
		Integer CdCurva = obj.get("CdCurva").asInt();
		String LdFecha = obj.get("LdFecha").asText();
		Date fechaFormated = null;
		Integer CdIndice = obj.get("CdIndice").asInt();
		Integer CdCurvaFor = obj.get("CdCurvaFor").asInt();
		
		try {
			fechaFormated = new SimpleDateFormat("yyyy-MM-dd").parse(LdFecha);
		} catch (ParseException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		double valorRetorno = fs.VaRFuDivisas(CdTransaccion, CdCurva, fechaFormated, CdIndice, CdCurvaFor);
		return valorRetorno;
	}
	
	@PostMapping("/VaRFuIndices")
	public double VaRFuIndices(@RequestBody ObjectNode obj) {

		String CdTransaccion = obj.get("CdTransaccion").asText();
		Integer CdCurva = obj.get("CdCurva").asInt();
		String LdFecha = obj.get("LdFecha").asText();
		Date fechaFormated = null;
		Integer CdIndice = obj.get("CdIndice").asInt();

		
		try {
			fechaFormated = new SimpleDateFormat("yyyy-MM-dd").parse(LdFecha);
		} catch (ParseException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		double valorRetorno = fs.VaRFuIndices(CdTransaccion, CdCurva, fechaFormated, CdIndice);
		return valorRetorno;
	}
	
	@PostMapping("/VaRFuTasas")
	public double VaRFuTasas(@RequestBody ObjectNode obj) {

		String CdTransaccion = obj.get("CdTransaccion").asText();
		Integer CdCurva = obj.get("CdCurva").asInt();
		String LdFecha = obj.get("LdFecha").asText();
		Date fechaFormated = null;

		
		try {
			fechaFormated = new SimpleDateFormat("yyyy-MM-dd").parse(LdFecha);
		} catch (ParseException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		double valorRetorno = fs.VaRFuTasas(CdTransaccion, CdCurva, fechaFormated);
		return valorRetorno;
	}
	
	@PostMapping("/VarPPPPPPP")
	public double VarPPPPPPP(@RequestBody ObjectNode obj) {

		String CdTransaccion = obj.get("CdTransaccion").asText();
		Integer CdCurva = obj.get("CdCurva").asInt();
		String LdFecha = obj.get("LdFecha").asText();
		Date fechaFormated = null;

		
		try {
			fechaFormated = new SimpleDateFormat("yyyy-MM-dd").parse(LdFecha);
		} catch (ParseException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		double valorRetorno = fs.VarPPPPPPP(CdTransaccion, CdCurva, fechaFormated);
		return valorRetorno;
	}
	

}
