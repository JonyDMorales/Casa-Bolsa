package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.CalculoDeVarSwap;
import com.phi.proyect.models.DeSwap;
import com.phi.proyect.models.Tvaluacionhoy;
import com.phi.proyect.models.VarOperacionesMd;
import com.phi.proyect.repository.CalculoDeVarSwapRepository;
import com.phi.proyect.repository.DeSwapRepository;
import com.phi.proyect.repository.DeSwapRepository2;
import com.phi.proyect.repository.MercadoDeDerivadosRepository;
import com.phi.proyect.repository.TvaluacionhoyRepository;

@Service
@Transactional(readOnly = true)
public class MercadoDeDerivadosService {

	@Autowired
	private DeSwapRepository2 deSwapRepo2;
	@Autowired
	private MercadoDeDerivadosRepository MercadoDeRepo;
	@Autowired
	private TvaluacionhoyRepository tvalRepo;
	@Autowired
	private CalculoDeVarSwapRepository calRepo;
	
	@Transactional
	public List<com.phi.proyect.models.DeSwap2> findAllDeSwap(){
		return this.deSwapRepo2.findAll();
	}
	
	@Transactional
	public String findValue() {
		return this.MercadoDeRepo.getValue(0);
	}
	
	@Transactional
    public int create(Tvaluacionhoy tvaluacionhoy) {
    	return this.tvalRepo.save2(tvaluacionhoy.getCdTransaccion(), tvaluacionhoy.getValuacion());
    	
    }
	
	@Transactional
    public int createCalculo(CalculoDeVarSwap calculoDeVarSwap) {
    	return this.calRepo.save2(calculoDeVarSwap.getCdTransaccion(), calculoDeVarSwap.getFecha(), calculoDeVarSwap.getValor(), calculoDeVarSwap.getPorcentaje());
    	
    }
}
