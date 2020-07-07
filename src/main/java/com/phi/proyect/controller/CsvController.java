package com.phi.proyect.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;
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
import com.mysql.cj.protocol.FullReadInputStream;
import com.phi.proyect.models.Caps;
import com.phi.proyect.models.CdCurvas;
import com.phi.proyect.models.CdInstrumento;
import com.phi.proyect.models.Curvas;
import com.phi.proyect.models.DeCapsfloor;
import com.phi.proyect.models.DeSwap;
import com.phi.proyect.models.FlujosCapsfloor;
import com.phi.proyect.models.FlujosSwap;
import com.phi.proyect.models.HCurvas;
import com.phi.proyect.models.LimitesMercado;
import com.phi.proyect.models.ResponseTransfer;
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
	
	
	@RequestMapping(value = "/hcurvas", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> uploadHCurvas(@RequestBody ObjectNode obj) {
		
		List<Curvas> lista = csvService.findByFkCdCurva(obj.get("0").asInt());
		
		if(lista.size() > 0) {		
		HCurvas curvas = new HCurvas();
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
		return new ResponseEntity<Object>(this.csvService.createCurvas(curvas), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Object>("No se encontro el valor " +obj.get("0").asInt()+ " tiene que hacer el registro primero en curvas", HttpStatus.CREATED);
		}
	}
	
	
	@RequestMapping(value = "/curvas", method = RequestMethod.POST)
	@ResponseBody
	public ResponseTransfer uploadCurvas(@RequestBody ObjectNode obj) {
		List<CdCurvas> lista = csvService.findByCdCurva(obj.get("0").asInt());
		if(lista.size() > 0) {
			
		
		Curvas curvas = new Curvas();
		curvas.setFkCdCurva(obj.get("0").asInt());
		curvas.setFhDate(obj.get("1").asText());
		curvas.setNuNodo(obj.get("2").asInt());
		curvas.setValor(obj.get("3").asDouble(0));
		String response = "Error";
		int resp = csvService.saveCurvas(curvas);
		System.out.println("isnert " + resp);
		if(resp == 1) {
			response = "Insertado Correctamente";
		}
		return new ResponseTransfer(response);
		}else {
			
			return new ResponseTransfer("No se encontro el valor " +obj.get("0").asInt()+ " tiene que hacer el registro primero en cd_curvas");
		}
	}
	
	
	@RequestMapping(value = "/decapsfloor", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> uploadDeCapsFloor(@RequestBody ObjectNode obj) {
		
		
		List<CdInstrumento> lista = csvService.findByIdIntrumento(obj.get("1").asInt());
		if(lista.size() > 0) {
			List<CdCurvas> lista2 = csvService.findByCdCurva(obj.get("4").asInt());
			if(lista2.size() > 0) {
				List<CdCurvas> lista3 = csvService.findByCdCurva(obj.get("5").asInt());
				if(lista3.size() > 0 ) {
					
					List<DeCapsfloor> lista4 = csvService.findByCdTransaccion(obj.get("0").asText());
					
					if(lista4.size() > 0) {
						return new ResponseEntity<Object>("El valor " +obj.get("0").asInt()+ " ya se encuentra registrado", HttpStatus.NOT_ACCEPTABLE);
					}else {
						DeCapsfloor deCapsfloor = new DeCapsfloor();
						deCapsfloor.setCdTransaccion(obj.get("0").asText());
						deCapsfloor.setCdInstrumento(obj.get("1").asInt());
						deCapsfloor.setFhInicio(obj.get("2").asText());
						deCapsfloor.setFhFin(obj.get("3").asText());
						deCapsfloor.setNuCurvaDescuento(obj.get("4").asInt());
						deCapsfloor.setNuCurvaVolatilidad(obj.get("5").asInt());
						deCapsfloor.setNuStrike(obj.get("6").asDouble());
						deCapsfloor.setTc(obj.get("7").asDouble());
						deCapsfloor.setNuNominal(obj.get("8").asInt());
						deCapsfloor.setNuConvencion(obj.get("9").asInt());
						
						return new ResponseEntity<>(this.csvService.saveDeCapsFloor(deCapsfloor), HttpStatus.CREATED);
						
					}
					
				}else {
					return new ResponseEntity<Object>("No se encontro el valor " +obj.get("5").asInt()+ " tiene que hacer el registro primero en cd_curvas", HttpStatus.NOT_FOUND);
				}
			}else {
				return new ResponseEntity<Object>("No se encontro el valor " +obj.get("4").asInt()+ " tiene que hacer el registro primero en cd_curvas", HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Object>("No se encontro el valor " +obj.get("1").asInt()+ " tiene que hacer el registro primero en cd_instrumento", HttpStatus.NOT_FOUND);
		}	
	}
	
	@RequestMapping(value = "/flujoscapsfloor", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> uploadFlujosCapsFloor(@RequestBody ObjectNode obj) {
		List<DeCapsfloor> lista = csvService.findByCdTransaccion(obj.get("0").asText());
		
		if(lista.size() > 0) {
			FlujosCapsfloor flujosCapsfloor = new FlujosCapsfloor();
			flujosCapsfloor.setCdTransaccion(obj.get("0").asText());
			flujosCapsfloor.setNuPago(obj.get("1").asInt());
			flujosCapsfloor.setFhPago(obj.get("2").asText());
			flujosCapsfloor.setNuMontoPago(obj.get("3").asDouble());
			flujosCapsfloor.setNuPlazoCupon(obj.get("4").asInt());
			flujosCapsfloor.setNuTasaVigente(obj.get("5").asDouble());
			flujosCapsfloor.setCdActivo(obj.get("6").asInt());
			return new ResponseEntity<Object>(this.csvService.saveFlujosCaps(flujosCapsfloor), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Object>("No se encontro el valor " +obj.get("0").asInt()+ " tiene que hacer el registro en de_capsfloor", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/deswap", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> uploadDeSwap(@RequestBody ObjectNode obj) {
		List<DeSwap> lista = csvService.findByTransaccion(obj.get("0").asText());
		if(lista.size() > 0) {
			return new ResponseEntity<Object>("El valor " +obj.get("0").asText()+ " ya se encuentra registrado", HttpStatus.NOT_ACCEPTABLE);
		}else {
			DeSwap deSwap = new DeSwap();
			deSwap.setCdTransaccion(obj.get("0").asText());
			deSwap.setCdInstrumento(obj.get("1").asInt());
			deSwap.setFhInicio(obj.get("2").asText());
			deSwap.setFhFin(obj.get("3").asText());
			deSwap.setNuCurvaDescuento(obj.get("4").asInt());
			deSwap.setNuFija(obj.get("5").asDouble());
			deSwap.setNuFlotante(obj.get("6").asInt());
			deSwap.setNuNominal(obj.get("7").asInt());
			deSwap.setTcBanco(obj.get("8").asDouble());
			deSwap.setTcCliente(obj.get("9").asDouble());
			deSwap.setCdBcoRecibe(obj.get("10").asInt());
			deSwap.setNuConvencion(obj.get("11").asDouble());
			return new ResponseEntity<Object>(this.csvService.saveDeSwap(deSwap), HttpStatus.CREATED);
		}
	}
	
	
	@RequestMapping(value = "/flujosSwap", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> uploadFlujosSwap(@RequestBody ObjectNode obj) {
		List<DeSwap> lista = csvService.findByTransaccion(obj.get("0").asText());
		if(lista.size() > 0) {
			FlujosSwap flujosSwap = new FlujosSwap();
			flujosSwap.setCdTransaccion(obj.get("0").asText());
			flujosSwap.setNuPago(obj.get("1").asInt());
			flujosSwap.setFhPago(obj.get("2").asText());
			flujosSwap.setNuMontoPago(obj.get("3").asDouble());
			flujosSwap.setNuPlazoCupon(obj.get("4").asInt());
			flujosSwap.setNuTasaVigente(obj.get("5").asDouble());
			flujosSwap.setCdActivo(obj.get("6").asInt());
			
			return new ResponseEntity<Object>(this.csvService.saveFlujosSwap(flujosSwap), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Object>("No se encontro el valor " +obj.get("0").asInt()+ " tiene que hacer el registro en de_swap", HttpStatus.NOT_FOUND);
		}
	}
	
}


