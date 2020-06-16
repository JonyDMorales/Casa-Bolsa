package com.phi.proyect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.repository.LimitesLineasRepository;

@Service
@Transactional(readOnly = true)
public class LimitesLineasService {
	
    @Autowired
	private LimitesLineasRepository llr ;
	
    @Transactional
    public LimitesLineas create(LimitesLineas limitesLineas) {
    	return this.llr.save(limitesLineas);
    	
    }
    
    @Transactional
    public LimitesLineas update(LimitesLineas limitesLineas) {
    	return this.llr.save(limitesLineas);
    }
    
    
    public List<LimitesLineas> findAll(){
    	return llr.findAll();
    }
    
    @Transactional
    public LimitesLineas findByContraparte(String contraparte){
    	return llr.findByContraparte(contraparte);
    }
    
    
    
    @Transactional
    public List<LimitesLineas> findByStatus(Integer tipostatus) {
    	return llr.findByStatus(tipostatus);
    }
    
    
    
    
    @Transactional
    public void delete(LimitesLineas limitesLineasOptional) {
    	//this.llr.deleteById(id);
    	this.llr.delete(limitesLineasOptional);
    }

}
