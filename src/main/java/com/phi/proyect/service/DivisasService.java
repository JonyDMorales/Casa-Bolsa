package com.phi.proyect.service;

import java.util.Date;
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
    
	public float distEst(Double valorEnvi) {
		return this.dr.distEst(valorEnvi);
	}
	
	public double VaRCapFloor(String valorEnvi1,int valorEnvi2,Date valorEnvi3,int valorEnvi4) {
		return this.dr.VaRCapFloor(valorEnvi1, valorEnvi2, valorEnvi3, valorEnvi4);
	}
	
	
	public double VaRFwdSwapStarting(String valorEnvi1,int valorEnvi2,Date valorEnvi3) {
		return this.dr.VaRFwdSwapStarting(valorEnvi1, valorEnvi2, valorEnvi3);
	}
	
	public double VaRSwapTIIE(String valorEnvi1,int valorEnvi2,Date valorEnvi3) {
		return this.dr.VaRSwapTIIE(valorEnvi1, valorEnvi2, valorEnvi3);
	}

}
