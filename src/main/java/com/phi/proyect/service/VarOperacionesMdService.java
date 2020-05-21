package com.phi.proyect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.VarOperacionesMd;
import com.phi.proyect.repository.LimitesLineasRepository;
import com.phi.proyect.repository.VarOperacionesMdRepository;

@Service
@Transactional(readOnly = true)
public class VarOperacionesMdService {

	@Autowired
	private VarOperacionesMdRepository vaOpMd;
	
	@Transactional
    public VarOperacionesMd create(VarOperacionesMd varOperacionesMd) {
    	return this.vaOpMd.save(varOperacionesMd);
    	
    }
	
}
