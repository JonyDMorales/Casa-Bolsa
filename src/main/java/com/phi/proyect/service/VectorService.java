package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.phi.proyect.models.Vector;
import com.phi.proyect.repository.VectorRepository;

@Service
@Transactional(readOnly = true)
public class VectorService {

	@Autowired
	VectorRepository vec;
	
	@Transactional
    public List<Vector> findIssue(String descripcion,int limites) {
    	return vec.findIssue(descripcion,limites);
    }
	
}
