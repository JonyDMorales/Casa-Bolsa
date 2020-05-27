package com.phi.proyect.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
}


