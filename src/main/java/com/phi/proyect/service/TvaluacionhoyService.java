package com.phi.proyect.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.Tvaluacionhoy;
import com.phi.proyect.repository.TvaluacionhoyRepository;

@Service
@Transactional(readOnly = true)
public class TvaluacionhoyService {

	@Autowired
	TvaluacionhoyRepository tvr;
	
	public List<Tvaluacionhoy>findBycdInstrumento(String cdInstrumento, String fecha){
		List<Tvaluacionhoy> listaValuacionesHoy = tvr.findBycdInstrumento(cdInstrumento, fecha);
		if(listaValuacionesHoy == null || listaValuacionesHoy.isEmpty()){
			return new ArrayList<>();
		}
		return  listaValuacionesHoy;
	} 
}
