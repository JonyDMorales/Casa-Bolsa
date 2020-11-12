package com.phi.proyect.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.Caps;
import com.phi.proyect.models.CdCurvas;
import com.phi.proyect.models.CdInstrumento;
import com.phi.proyect.models.Curvas;
import com.phi.proyect.models.CurvasParametria;
import com.phi.proyect.models.DeCapsfloor;
import com.phi.proyect.models.DeFuturos;
import com.phi.proyect.models.DeSwap;
import com.phi.proyect.models.FlujosCapsfloor;
import com.phi.proyect.models.FlujosSwap;
import com.phi.proyect.models.HCurvas;
import com.phi.proyect.models.HCurvas2;
import com.phi.proyect.repository.CdCurvasRepository;
import com.phi.proyect.repository.CdInstrumentoRepository;
import com.phi.proyect.repository.CsvRepository;
import com.phi.proyect.repository.CurvasParametriaRepository;
import com.phi.proyect.repository.CurvasRepository;
import com.phi.proyect.repository.DeCapsfloorRepository;
import com.phi.proyect.repository.DeFuturosRepository;
import com.phi.proyect.repository.DeSwapRepository;
import com.phi.proyect.repository.FlujosCapsfloorRepository;
import com.phi.proyect.repository.FlujosSwapRepository;
import com.phi.proyect.repository.HCurvasRepositiry;
import com.phi.proyect.repository.HCurvasRepositiry2;


@Service
@Transactional(readOnly = true)
public class CsvService {

	@Autowired
	private CsvRepository csvRepo;
	@Autowired
	private HCurvasRepositiry curRepo;
	@Autowired
	private HCurvasRepositiry2 HcurRepo;
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
	@Autowired 
	private CurvasParametriaRepository curvasParametros;
	
	@Transactional
    public Caps create(Caps caps) {
    	return this.csvRepo.save(caps);
    	
    }
	
	
	@Transactional
    public int createCurvasNuevo(double[] valores,int curva,String fecha) {
    	return this.curRepo.insertHcurvasNuevo(curva, fecha, valores[0], valores[1] ,valores[2],valores[3],valores[4],valores[5],valores[6],valores[7],valores[8],valores[9],valores[10],valores[11],valores[12],valores[13],valores[14],valores[15],valores[16],valores[17],valores[18],valores[19],valores[20],valores[21],valores[22],valores[23],valores[24],valores[25],valores[26],valores[27],valores[28],valores[29],valores[30],valores[31],valores[32],valores[33],valores[34],valores[35],valores[36],valores[37],valores[38],valores[39],valores[40],valores[41],valores[42],valores[43],valores[44],valores[45],valores[46],valores[47],valores[48],valores[49],valores[50],valores[51],valores[52],valores[53],valores[54],valores[55],valores[56],valores[57],valores[58],valores[59],valores[60],valores[61],valores[62],valores[63],valores[64],valores[65],valores[66],valores[67],valores[68],valores[69],valores[70],valores[71],valores[72],valores[73],valores[74],valores[75],valores[76],valores[77],valores[78],valores[79],valores[80],valores[81],valores[82],valores[83],valores[84],valores[85],valores[86],valores[87],valores[88],valores[89],valores[90],valores[91],valores[92],valores[93],valores[94],valores[95],valores[96],valores[97],valores[98],valores[99],valores[100],valores[101],valores[102],valores[103],valores[104],valores[105],valores[106]);    	
    }
	
//	@Transactional
//    public int createCurvas(HCurvas curvas) {
//    	return this.curRepo.save2(curvas.getCdCurva(),curvas.getFhDate(),curvas.getN1(),curvas.getN2(),curvas.getN3(),curvas.getN4(),curvas.getN5(),curvas.getN6(),curvas.getN7(),curvas.getN8(),curvas.getN9(),curvas.getN10(),curvas.getN11(),curvas.getN12(),curvas.getN13(),curvas.getN14(),curvas.getN15(),curvas.getN16(),curvas.getN17(),curvas.getN18(),curvas.getN19(),curvas.getN20(),curvas.getN21(),curvas.getN22(),curvas.getN23(),curvas.getN24(),curvas.getN25(),curvas.getN26(),curvas.getN27(),curvas.getN28());    	
//    }
	
	public List<Curvas> findByFkCdCurva(int id){
    	return curvasRepo.findByFkCdCurva(id);
    }
	
	@Transactional
	public int saveCurvas(Curvas curvas) {
		return this.curvasRepo.save2(curvas.getFkCdCurva(), curvas.getFhDate(), curvas.getNuNodo(), curvas.getValor());
	}
	
	@Transactional
	 public void DeleteAllCurvas() {
		curvasRepo.deleteAll();
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
		return this.deSwapRepo.save2(deSwap.getCdTransaccion(), deSwap.getCdInstrumento(), deSwap.getFhInicio(), deSwap.getFhFin(), deSwap.getNuCurvaDescuento(), deSwap.getCurvaFlot(), deSwap.getNuFija(),deSwap.getNuFlotante(), deSwap.getNuNominal(), deSwap.getTcBanco(),deSwap.getTcCliente(),deSwap.getCdBcoRecibe(),deSwap.getNuConvencion(), deSwap.getTpProducto(), deSwap.getTpTransaccion(), deSwap.getTpDescuento());
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
	
	@Transactional
    public List<HCurvas2> getUltimoRegistro(int curva) {
    	return this.HcurRepo.getUltimoRegistro(curva);
    }
	
	@Transactional
    public int deleteUltimoRegistro(String fecha,int curva) {
		this.HcurRepo.setSafeMode();
    	return this.HcurRepo.deleteUltimo(fecha,curva);
    }
	
	@Transactional
	public List<Curvas> getResultados(){
		return this.curvasRepo.getRegistros();
	}
	
	@Transactional
    public int deleteAllCurvas() {
		this.HcurRepo.setSafeMode();
    	this.curvasRepo.deleteAll();
    	return 0;
    }
	
	@Transactional
	public List<FlujosSwap> getResultadosFlujosSwap(){
		return this.flujosSwapRepo.getRegistros();
	}
	
	@Transactional
	public int deleteDeSwap() {
		this.HcurRepo.setSafeMode();
		this.deSwapRepo.deleteAllsSwaf();

		return 0;
	}
	
	@Transactional
	public int deleteFlujosSwap() {
		this.HcurRepo.setSafeMode();
		this.flujosSwapRepo.deleteAllFlujos();
		return 0;
	}
	
	@Transactional
	public List<CurvasParametria> getCurvasParametria(){
		return this.curvasParametros.curvasParametria();
	}
	
	@Transactional
	public int deleteHcurvas(String fecha) {
		this.HcurRepo.setSafeMode();
		this.HcurRepo.deleteMismaFecha(fecha);
		return 1;
	}
}
