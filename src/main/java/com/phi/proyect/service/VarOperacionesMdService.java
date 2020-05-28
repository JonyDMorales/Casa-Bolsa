package com.phi.proyect.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.DiasInhabiles;
import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.VarLimite;
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
	
	@Transactional
	public List<VarOperacionesMd> findByFecha(String fecha) {
		return this.vaOpMd.findByFecha(fecha);
	}
	
	@Transactional
	public List<VarOperacionesMd> findByFechaAndProducto(String fecha,String producto) {
		return this.vaOpMd.findByFechaAndInstrumento(fecha,producto);
	}
	
}
