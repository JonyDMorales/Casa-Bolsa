package com.phi.proyect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.Caps;
import com.phi.proyect.repository.CsvRepository;


@Service
@Transactional(readOnly = true)
public class CsvService {

	@Autowired
	private CsvRepository csvRepo;
	
	@Transactional
    public Caps create(Caps caps) {
    	return this.csvRepo.save(caps);
    	
    }
}
