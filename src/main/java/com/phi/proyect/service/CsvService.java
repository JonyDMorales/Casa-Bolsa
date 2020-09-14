package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.Caps;
import com.phi.proyect.models.CdCurvas;
import com.phi.proyect.models.CdInstrumento;
import com.phi.proyect.models.Curvas;
import com.phi.proyect.models.DeCapsfloor;
import com.phi.proyect.models.DeFuturos;
import com.phi.proyect.models.DeSwap;
import com.phi.proyect.models.FlujosCapsfloor;
import com.phi.proyect.models.FlujosSwap;
import com.phi.proyect.models.HCurvas;
import com.phi.proyect.repository.CdCurvasRepository;
import com.phi.proyect.repository.CdInstrumentoRepository;
import com.phi.proyect.repository.CsvRepository;
import com.phi.proyect.repository.CurvasRepository;
import com.phi.proyect.repository.DeCapsfloorRepository;
import com.phi.proyect.repository.DeFuturosRepository;
import com.phi.proyect.repository.DeSwapRepository;
import com.phi.proyect.repository.FlujosCapsfloorRepository;
import com.phi.proyect.repository.FlujosSwapRepository;
import com.phi.proyect.repository.HCurvasRepositiry;


@Service
@Transactional(readOnly = true)
public class CsvService {

	@Autowired
	private CsvRepository csvRepo;
	@Autowired
	private HCurvasRepositiry curRepo;
	@Autowired
	private CurvasRepository curvasRepo;
	@Autowired 
	private CdCurvasRepository cdCurvasRepo;
	@Autowired
	private DeCapsfloorRepository deCapsFloorRepo;
	@Autowired
	private CdInstrumentoRepository cdIntrumentoRepo;
	@Autowired
	private FlujosCapsfloorRepository flujosCapsFloorRepo;
	@Autowired
	private DeSwapRepository deSwapRepo;
	@Autowired
	private FlujosSwapRepository flujosSwapRepo;
	@Autowired 
	private DeFuturosRepository deFuturosRepo;
	
	@Transactional
    public Caps create(Caps caps) {
    	return this.csvRepo.save(caps);
    	
    }
	
	
	@Transactional
    public int createCurvas(HCurvas curvas) {
    	return this.curRepo.save2(curvas.getCdCurva(),curvas.getFhDate(),curvas.getN1(),curvas.getN2(),curvas.getN3(),curvas.getN4(),curvas.getN5(),curvas.getN6(),curvas.getN7(),curvas.getN8(),curvas.getN9(),curvas.getN10(),curvas.getN11(),curvas.getN12(),curvas.getN13(),curvas.getN14(),curvas.getN15(),curvas.getN16(),curvas.getN17(),curvas.getN18(),curvas.getN19(),curvas.getN20(),curvas.getN21(),curvas.getN22(),curvas.getN23(),curvas.getN24(),curvas.getN25(),curvas.getN26(),curvas.getN27(),curvas.getN28());    	
    }
	
	public List<Curvas> findByFkCdCurva(int id){
    	return curvasRepo.findByFkCdCurva(id);
    }
	
	@Transactional
	public int saveCurvas(Curvas curvas) {
		return this.curvasRepo.save2(curvas.getFkCdCurva(), curvas.getFhDate(), curvas.getNuNodo(), curvas.getValor());
	}
	
	public List<CdCurvas> findByCdCurva(int id) {
		return this.cdCurvasRepo.findByCdCurva(id);
		
	}
	
	@Transactional
	public int saveDeCapsFloor(DeCapsfloor deCapsfloor) {
		return this.deCapsFloorRepo.save2(deCapsfloor.getCdTransaccion(),deCapsfloor.getCdInstrumento(), deCapsfloor.getFhInicio(),deCapsfloor.getFhFin(),deCapsfloor.getNuCurvaDescuento(),deCapsfloor.getNuCurvaVolatilidad(),deCapsfloor.getNuStrike(),deCapsfloor.getTc(), deCapsfloor.getNuNominal(),deCapsfloor.getNuConvencion());
	}
	
	@Transactional
	public List<CdInstrumento> findByIdIntrumento(int id){
		return this.cdIntrumentoRepo.findByFkIdInstrumento(id);
	}
	
	@Transactional
	public List<DeCapsfloor> findByCdTransaccion(String id){
		return this.deCapsFloorRepo.findByCdTransaccion(id);
	}
	
	@Transactional
	public int saveFlujosCaps(FlujosCapsfloor flujosCapsfloor) {
		return this.flujosCapsFloorRepo.save2(flujosCapsfloor.getCdTransaccion(),flujosCapsfloor.getNuPago(),flujosCapsfloor.getFhPago(),flujosCapsfloor.getNuMontoPago(),flujosCapsfloor.getNuPlazoCupon(),flujosCapsfloor.getNuTasaVigente(),flujosCapsfloor.getCdActivo());
	}
	
	@Transactional
	public int saveDeSwap(DeSwap deSwap) {
		return this.deSwapRepo.save2(deSwap.getCdTransaccion(), deSwap.getCdInstrumento(), deSwap.getFhInicio(), deSwap.getFhFin(), deSwap.getNuCurvaDescuento(), deSwap.getNuCurvaDescFlot(), deSwap.getNuFija(),deSwap.getNuFlotante(), deSwap.getNuNominal(), deSwap.getTcBanco(),deSwap.getTcCliente(),deSwap.getCdBcoRecibe(),deSwap.getNuConvencion(), deSwap.getTpProducto(), deSwap.getTpTransaccion(), deSwap.getTpEstandar());
	}
	
	@Transactional
	public List<DeSwap> findByTransaccion(String id){
		return this.deSwapRepo.findByTransaccion(id);
	}
	
	@Transactional
	public int saveFlujosSwap(FlujosSwap flujosSwap) {
		return this.flujosSwapRepo.save2(flujosSwap.getCdTransaccion(),flujosSwap.getNuPago(),flujosSwap.getFhPago(),flujosSwap.getNuMontoPago(),flujosSwap.getNuPlazoCupon(),flujosSwap.getNuTasaVigente(),flujosSwap.getCdActivo(),flujosSwap.getFh_Pago_b(),flujosSwap.getNu_Monto_Pago_b(),flujosSwap.getNu_PlazoCupon_b());
	}
	
	@Transactional
	public List<DeFuturos> findByCodigoDeTransaccion(int id){
		return this.deFuturosRepo.findByCodigoDeTransaccion(id);
	}
	
	@Transactional
    public DeFuturos createDeFuturos(DeFuturos deFuturos) {
    	return this.deFuturosRepo.save(deFuturos);
    	
    }
}
