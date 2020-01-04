package com.phi.proyect.service;

import java.util.List;

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
	
    public void save(LimitesLineas limitesLineas) {
    	
    	this.llr.save(limitesLineas);
    	
    }
    
    
    public List<LimitesLineas> findAll(){
    	
    	return llr.findAll();
    	
    }

}
