package com.phi.proyect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.Caps;
import com.phi.proyect.models.Curvas;
import com.phi.proyect.repository.CsvRepository;
import com.phi.proyect.repository.CurvasRepositiry;


@Service
@Transactional(readOnly = true)
public class CsvService {

	@Autowired
	private CsvRepository csvRepo;
	@Autowired
	private CurvasRepositiry curRepo;
	
	@Transactional
    public Caps create(Caps caps) {
    	return this.csvRepo.save(caps);
    	
    }
	
	
	@Transactional
    public Curvas createCurvas(Curvas curvas) {
    	return this.curRepo.save(curvas);
    	
    }
}
