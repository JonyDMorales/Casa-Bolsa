package com.phi.proyect.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.CalculoDeVarSwap;
import com.phi.proyect.repository.CalculoDeVarSwapRepository;

@Service
@Transactional(readOnly = true)
public class CalculoDeVarSwapService {
	
	@Autowired
	CalculoDeVarSwapRepository cdvsr;
	
	public List<CalculoDeVarSwap> findByCdInstrumento(String cdInstrumento, String fecha){
		List<CalculoDeVarSwap> listCalculoDeVarSwap = cdvsr.findByCdInstrumento(cdInstrumento, fecha);

		if(listCalculoDeVarSwap == null || listCalculoDeVarSwap.isEmpty()){
			return new ArrayList<>();
		}
		return listCalculoDeVarSwap;
	}
	
}
