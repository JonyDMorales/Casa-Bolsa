package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.Caps;
import com.phi.proyect.models.Curvas;
import com.phi.proyect.models.LimitesMercado;
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
    public int createCurvas(Curvas curvas) {
    	return this.curRepo.save2(curvas.getCdCurva(),curvas.getFhDate(),curvas.getN1(),curvas.getN2(),curvas.getN3(),curvas.getN4(),curvas.getN5(),curvas.getN6(),curvas.getN7(),curvas.getN8(),curvas.getN9(),curvas.getN10(),curvas.getN11(),curvas.getN12(),curvas.getN13(),curvas.getN14(),curvas.getN15(),curvas.getN16(),curvas.getN17(),curvas.getN18(),curvas.getN19(),curvas.getN20(),curvas.getN21(),curvas.getN22(),curvas.getN23(),curvas.getN24(),curvas.getN25(),curvas.getN26(),curvas.getN27(),curvas.getN28());    	
    }
	
	public List<Curvas> findAll(){
    	return curRepo.findAll();
    }
}
