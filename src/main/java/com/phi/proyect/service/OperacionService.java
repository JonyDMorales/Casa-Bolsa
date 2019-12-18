package com.phi.proyect.service;

import com.phi.proyect.models.Operacion;
import com.phi.proyect.repository.OperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*En los servicios se implementa el crud de las tablas*/

@Service
public class OperacionService {

    @Autowired
    private OperacionRepository operacionRepository;

    public Iterable<Operacion> findAll(){
        return this.operacionRepository.findAll();
    }
}
