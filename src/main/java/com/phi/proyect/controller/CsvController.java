package com.phi.proyect.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.phi.proyect.models.Caps;
import com.phi.proyect.models.Curvas;
import com.phi.proyect.models.LimitesMercado;
import com.phi.proyect.service.CsvService;
import com.phi.proyect.service.VarOperacionesMdService;

import io.jsonwebtoken.io.IOException;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/archivos")
public class CsvController {
	
	private final CsvService csvService;
	
	public CsvController(CsvService csvService) {
		super();
		this.csvService = csvService;
	}
	
	@RequestMapping(value = "/csv", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Caps> archivoUpload(@RequestBody ObjectNode obj) {
		Caps caps = new Caps();
		caps.setCdTransaccion(obj.get("0").asText());
		caps.setCdInstrumento(obj.get("1").asInt());
		caps.setFhInicio(obj.get("2").asText());
		caps.setFhFin(obj.get("3").asText());
		caps.setNuCurvaDescuento(obj.get("4").asInt());
		caps.setNuCurvaVolatilidad(obj.get("5").asInt());
		caps.setNuStrike(obj.get("6").asDouble());
		caps.setTc(obj.get("7").asDouble());
		caps.setNuNominal(obj.get("8").asInt());
		caps.setNuConvencion(obj.get("9").asInt());
		return new ResponseEntity<>(this.csvService.create(caps), HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/curvas", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> uploadCurvas(@RequestBody ObjectNode obj) {
		Curvas curvas = new Curvas();
		curvas.setCdCurva(obj.get("0").asInt());
		curvas.setFhDate(obj.get("1").asText());
		curvas.setN1(obj.get("2").asDouble());
		curvas.setN2(obj.get("3").asDouble());
		curvas.setN3(obj.get("4").asDouble());
		curvas.setN4(obj.get("5").asDouble());
		curvas.setN5(obj.get("6").asDouble());
		curvas.setN6(obj.get("7").asDouble());
		curvas.setN7(obj.get("8").asDouble());
		curvas.setN8(obj.get("9").asDouble());
		curvas.setN9(obj.get("10").asDouble());
		curvas.setN10(obj.get("11").asDouble());
		curvas.setN11(obj.get("12").asDouble());
		curvas.setN12(obj.get("13").asDouble());
		curvas.setN13(obj.get("14").asDouble());
		curvas.setN14(obj.get("15").asDouble());
		curvas.setN15(obj.get("16").asDouble());
		curvas.setN16(obj.get("17").asDouble());
		curvas.setN17(obj.get("18").asDouble());
		curvas.setN18(obj.get("19").asDouble());
		curvas.setN19(obj.get("20").asDouble());
		curvas.setN20(obj.get("21").asDouble());
		curvas.setN21(obj.get("22").asDouble());
		curvas.setN22(obj.get("23").asDouble());
		curvas.setN23(obj.get("24").asDouble());
		curvas.setN24(obj.get("25").asDouble());
		curvas.setN25(obj.get("26").asDouble());
		curvas.setN26(obj.get("27").asDouble());
		curvas.setN27(obj.get("28").asDouble());
		curvas.setN28(obj.get("29").asDouble());
		System.out.println(curvas);
		return new ResponseEntity<Object>(this.csvService.createCurvas(curvas), HttpStatus.CREATED);
	}
	
	@GetMapping(value= "/findAll")
	public List<Curvas> lista() {
		List<Curvas> lista = csvService.findAll();
		return lista;
	}
}


