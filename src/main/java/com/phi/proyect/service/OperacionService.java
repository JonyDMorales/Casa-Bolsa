package com.phi.proyect.service;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.Operacion;
import com.phi.proyect.models.OperacionesMd;
import com.phi.proyect.repository.OperacionRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*En los servicios se implementa el crud de las tablas*/

@Service
@Transactional(readOnly = true)
public class OperacionService {

    @Autowired
    private OperacionRepository operacionRepository;

    public List<OperacionesMd> findAll(){
    	return operacionRepository.findAll();
    }
    
	public List<OperacionesMd> find(String contraparte){
		return this.operacionRepository.find(contraparte);
	}
	
	public List<OperacionesMd> find2(String contraparte){
		return this.operacionRepository.find2(contraparte);
	}
}
