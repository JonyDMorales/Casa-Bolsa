package com.phi.proyect.controller;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.phi.proyect.models.VarOperacionesMd;
import com.phi.proyect.service.VarOperacionesMdService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/operacionesMd")
public class VarOperacionesMdController {
	private final VarOperacionesMdService mdService;
	
	public VarOperacionesMdController(VarOperacionesMdService mdService) {
		super();
		this.mdService = mdService;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public List<VarOperacionesMd> lista(@RequestBody ObjectNode obj) {
		String fecha = obj.get("fecha").asText();
		List<VarOperacionesMd> list = mdService.findByFecha(fecha);
		
		return list;
	}
	
}
