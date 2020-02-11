package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.Logaritmo;
import com.phi.proyect.repository.LogaritmoRepository;

@Service
@Transactional(readOnly = true)
public class LogaritmoService {
	
	@Autowired
	private LogaritmoRepository logr;
	
	
	@Transactional
    public List<Logaritmo> findByDescripcion(String descripcion) {
    	return logr.findByDescripcion(descripcion);
    }
	

}
