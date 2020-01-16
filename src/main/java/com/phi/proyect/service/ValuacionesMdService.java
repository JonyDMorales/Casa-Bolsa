package com.phi.proyect.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.ValuacionesMd;
import com.phi.proyect.repository.ValuacionesMdRepository;

@Service
@Transactional(readOnly = true)
public class ValuacionesMdService {
	
	
	@Autowired
	private ValuacionesMdRepository vmr;

	
	public List<ValuacionesMd>findValMer(Integer idOperacion) {
		return this.vmr.findValMer(idOperacion);
	}
	

}
