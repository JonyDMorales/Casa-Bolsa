package com.phi.proyect.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.CalculoDeVarSwap;
import com.phi.proyect.models.DeSwap;
import com.phi.proyect.models.Tvaluacionhoy;
import com.phi.proyect.models.VarOperacionesMd;
import com.phi.proyect.models.Vista;
import com.phi.proyect.repository.CalculoDeVarSwapRepository;
import com.phi.proyect.repository.DeSwapRepository;
import com.phi.proyect.repository.DeSwapRepository2;
import com.phi.proyect.repository.MercadoDeDerivadosRepository;
import com.phi.proyect.repository.TvaluacionhoyRepository;
import com.phi.proyect.repository.VistaRepository;

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
	@Autowired
	private VistaRepository vista;
	
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
     	return this.tvalRepo.save2(tvaluacionhoy.getCdTransaccion(), tvaluacionhoy.getValuacion(),tvaluacionhoy.getCdInstrumento(),tvaluacionhoy.getFecha(),tvaluacionhoy.getVar1(),tvaluacionhoy.getVar2(),tvaluacionhoy.getVar3(),tvaluacionhoy.getPortafolio());
    	
    }
	
	@Transactional
    public int createHistorico(Tvaluacionhoy tvaluacionhoy) {
     	return this.tvalRepo.save3(tvaluacionhoy.getCdTransaccion(), tvaluacionhoy.getValuacion(),tvaluacionhoy.getCdInstrumento(),tvaluacionhoy.getVar1(),tvaluacionhoy.getVar2(),tvaluacionhoy.getVar3(),tvaluacionhoy.getPortafolio(),tvaluacionhoy.getFecha());
    	
    }
	
	@Transactional
	 public void DeleteAll() {
		tvalRepo.deleteAll();
    }
	
	public List<Tvaluacionhoy>findByInsertHistorico(String cdTransaccion, String fecha){
		return tvalRepo.findByInsertHistorico(cdTransaccion, fecha);
	}
	
	
	public List<Vista> selectVista() {
		return vista.selectVista();
	}
	
	@Transactional
    public int saveDeVarSwap(CalculoDeVarSwap cal) {
     	return this.calRepo.saveDeVarSwap(cal.getCdInstrumento(),cal.getFecha(),cal.getVar1(),cal.getVar2(),cal.getVar3());
    	
    }

}
