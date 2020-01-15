package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.Divisas;
import com.phi.proyect.repository.DivisasRepository;


@Service
@Transactional(readOnly = true)
public class DivisasService {
	
	
    @Autowired
	private DivisasRepository dr;
    
    
    
	public List<Divisas> findFirstByTvOrderByDateDesc(String divisa) {
		return this.dr.findFirstByTvOrderByDateDesc(divisa);
	}
    
    

}
