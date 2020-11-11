package com.phi.proyect.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.phi.proyect.algoritmos.Algoritmos;
import com.phi.proyect.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.phi.proyect.models.CalculoDeVarSwap;
import com.phi.proyect.models.DiasInhabiles;
import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.Logaritmo;
import com.phi.proyect.models.OperacionesMd;
import com.phi.proyect.models.Tvaluacionhoy;
import com.phi.proyect.models.ValuacionesMd;
import com.phi.proyect.models.VarLimite;
import com.phi.proyect.models.VarOperacionesMd;
import com.phi.proyect.models.Vector;
import com.phi.proyect.models.VectorPreciosDia;
import com.phi.proyect.vo.MesaDerivados;
import com.phi.proyect.vo.MesadeDinero;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/logaritmo")
public class LogaritmoController {

	private final LogaritmoService log;
	private final VectorService vecSer;
	private final VectorPreciosDiaService vecpds;
	private final DiasInhabilesService dis;
	private final VarLimiteService varlimSer;
	private final ValuacionesMdService vs;
	private final OperacionService ops;
	private final VarOperacionesMdService vaOpMdSer;
	private final TvaluacionhoyService tvSer;
	private final CalculoDeVarSwapService cdvss;

	@Autowired
	public MercadoDeDerivadosService deDerivadosService;


	@Autowired
	Algoritmos algoritmos;

	public LogaritmoController(LogaritmoService log, VectorService vecSer, VectorPreciosDiaService vecpds,
			DiasInhabilesService dis, VarLimiteService varlimSer, ValuacionesMdService vs,OperacionService ops,VarOperacionesMdService vaOpMdSer, TvaluacionhoyService tvSer, CalculoDeVarSwapService cdvss) {
		super();
		this.log = log;
		this.vecSer = vecSer;
		this.vecpds = vecpds;
		this.dis = dis;
		this.varlimSer = varlimSer;
		this.vs = vs;
		this.ops = ops;
		this.vaOpMdSer = vaOpMdSer;
		this.tvSer = tvSer;
		this.cdvss = cdvss;
	}

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("titulo", "Logaritmo");
		mav.setViewName("logaritmo");
		return mav;
	}

	@RequestMapping(value = "/log", method = RequestMethod.POST)
	@ResponseBody
	public List<com.phi.proyect.vo.Logaritmo> lista(@RequestBody ObjectNode obj) {
		String descripcion = obj.get("descripcion").asText();
		String fecha = obj.get("fecha").asText();
		Double tasa = obj.get("tasa").asDouble();
		
		List<Logaritmo> parametro = log.findByDescripcion(descripcion);
		List<VectorPreciosDia> listaVectorDia = vecpds.findVectorPrecioDia(descripcion);
		List<com.phi.proyect.vo.Logaritmo> listReturn = new ArrayList<com.phi.proyect.vo.Logaritmo>();
		List<Double> logaritmos = new ArrayList<>();
		if (!parametro.isEmpty() && !listaVectorDia.isEmpty()) {
			String[] desc = parametro.get(0).getValorDelParametro().split("\\|");
			
			if (desc[1].equals("market_surcharge")) {
				List<Vector> listaValores = vecSer.findIssue(parametro.get(0).getDescripcion(), Integer.parseInt(desc[0]));
				int cont = 1;
				for (int i = 0; i < listaValores.size() - 1; i++) {
					//System.out.println(listaValores.get(i).getMarketSurcharge() + " / " + listaValores.get(cont).getMarketSurcharge());
					float division = (listaValores.get(i).getMarketSurcharge() / listaValores.get(cont).getMarketSurcharge());
					Double logaritmo = Math.log(division);
					//System.out.println("LOG: " + logaritmo);

					if (Double.isNaN(logaritmo)) {
					    logaritmo = 1.0; // lo puse porque en ocaciones viene con NaN
					}

					logaritmos.add(logaritmo);
					cont++;
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date fechaRegistro = sdf.parse(fecha, new ParsePosition(0));
				for(Double logaritmo : logaritmos){
					Double calculaPrecio = algoritmos.CalculaPrecio(listaVectorDia.get(0), fechaRegistro, logaritmo + tasa);
					listReturn.add(new com.phi.proyect.vo.Logaritmo(logaritmo,calculaPrecio));
					System.out.println("algoritmo - " + calculaPrecio);
				}

				return listReturn;
			}
			return listReturn;
		}

		return listReturn;
	}

	@RequestMapping(value = "/log2", method = RequestMethod.POST)
	public List<VarOperacionesMd> lista2() {
		List<com.phi.proyect.vo.Logaritmo> listReturn = new ArrayList<com.phi.proyect.vo.Logaritmo>();
		List<OperacionesMd> lista = ops.findStatus();
		List<Double> logaritmos = new ArrayList<>();
		List<VarOperacionesMd> list = new ArrayList<>();
		
		for (int i = 0; i < lista.size(); i++) {
			List<Vector> listaValores = vecSer.findIssue(lista.get(i).getInstrumento(), 251);
			List<VectorPreciosDia> listaVectorDia = vecpds.findVectorPrecioDia(lista.get(i).getInstrumento());
			int cont = 1;
			for (int j = 0; j < listaValores.size() - 1; j++) {
				float division = (listaValores.get(j).getMarketSurcharge() / listaValores.get(cont).getMarketSurcharge());
				Double logaritmo = Math.log(division);

				if (Double.isNaN(logaritmo)) {
				    logaritmo = 1.0; // lo puse porque en ocaciones viene con NaN
				}

				logaritmos.add(logaritmo);
				cont++;
			}
			
			Date date = new Date();
			Double param1 = 0.0;
			Double param2 = 0.0;
			Double param3 = 0.0;
			for(Double logaritmo : logaritmos){
				Double calculaPrecio = algoritmos.CalculaPrecio(listaVectorDia.get(0), date, logaritmo);
				listReturn.add(new com.phi.proyect.vo.Logaritmo(logaritmo,calculaPrecio));
				if(calculaPrecio > param1) {
					param1 = calculaPrecio;
				}else if(calculaPrecio > param2) {
					param2 = calculaPrecio;
				}else if(calculaPrecio > param3) {
					param3 = calculaPrecio;
				}
			}
				
			
			if(listaValores.size() > 0) {
				Date date2 = Calendar.getInstance().getTime();  
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
				String fecha = dateFormat.format(date2);
				createVarOperacionMd(lista.get(i).getInstrumento(), fecha, param1, param2, param3);
				list.add(new VarOperacionesMd(lista.get(i).getInstrumento(), fecha, param1, param2, param3));
				System.out.println("instrumento - " + lista.get(i).getInstrumento());
				System.out.println("fecha - " + fecha);
				System.out.println("param1 - " + param1);
				System.out.println("param2 - " + param2);
				System.out.println("param3 - " + param3);
			}
			
		}
		return list;
	}
	
	
	public ResponseEntity<VarOperacionesMd> createVarOperacionMd(String instrumento,String fecha,Double param1,Double param2,Double param3) {
		VarOperacionesMd  varOperacionesMd = new VarOperacionesMd();
		 varOperacionesMd.setInstrumento(instrumento);
		 varOperacionesMd.setFecha(fecha);
		 varOperacionesMd.setVarNoventaNueve(param1);
		 varOperacionesMd.setVarNoventaSiete(param2);
		 varOperacionesMd.setVarNoventaCinco(param3);
		return new ResponseEntity<>(this.vaOpMdSer.create(varOperacionesMd), HttpStatus.CREATED);
	}
	
	@PostMapping("/calcular/precio")
	public double calcular(@RequestBody ObjectNode obj) {
		String descripcion = obj.get("descripcion").asText();
		String fecha = obj.get("fecha").asText();
		Double tasa = obj.get("tasa").asDouble();

		List<VectorPreciosDia> lista = vecpds.findVectorPrecioDia(descripcion);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("position 1" + lista.get(0));
		System.out.println("position 2" + sdf.parse(fecha, new ParsePosition(0)));
		System.out.println("position 3" + tasa);
		return algoritmos.CalculaPrecio(lista.get(0), sdf.parse(fecha, new ParsePosition(0)), tasa);

	}

	@GetMapping(value = "/mesaDinero")
	public List<MesadeDinero> mesaDinero() {
		List<com.phi.proyect.vo.MesadeDinero> listReturn = new ArrayList<com.phi.proyect.vo.MesadeDinero>();
		List<VectorPreciosDia> lista = vecpds.findAll();
		
		 	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		    Date date = new Date();  
		    String fechaEnvio= ""+formatter.format(date)+"";
		    //System.out.println(fechaEnvio); 
		    fechaEnvio="2020-05-20";
		
		for (int i = 0; i < lista.size(); i++) {
			List<VarLimite> lista2 = varlimSer.findAll(lista.get(i).getIssue());
			List<ValuacionesMd> lista3 = vs.findValorLibros(lista.get(i).getIssue());
			List<VarOperacionesMd> lista4 = vaOpMdSer.findByFechaAndProducto(fechaEnvio,lista.get(i).getIssue());
			if (lista2.size() > 0) {
				
				Double valor = 0.0;
				Double multi = 0.0;
				
				Double valor1 = null;
				Double valor2 = null;
				Double valor3 = null;
				if (lista3.size() > 0) {
					valor = lista3.get(0).getValorEnLibros();
					multi = valor * Double.parseDouble(lista3.get(0).getTitulos());
				}
				
				if(lista4.size() > 0) {
					valor1=lista4.get(0).getVarNoventaNueve();
					valor2=lista4.get(0).getVarNoventaSiete();
					valor3=lista4.get(0).getVarNoventaCinco();
				}
				
				listReturn.add(new com.phi.proyect.vo.MesadeDinero(lista.get(i).getIdValmerPriceVector(),
						lista.get(i).getIssue(), lista2.get(0).getLimite(), valor, multi,valor1,valor2,valor3));
			}
		}
		return listReturn;
	}
	
	
	
	@GetMapping(value = "/mesaDerivados")
	public List<Object> mesaDerivados() {
		List<Object> retorno = new ArrayList <Object>();
		
		List<com.phi.proyect.vo.MesaDerivados> nivelDetalle = new ArrayList<com.phi.proyect.vo.MesaDerivados>();
		String fecha = deDerivadosService.findValueDate();
		List<Tvaluacionhoy> listaTvaluaciones= tvSer.findBycdInstrumento("2", fecha);
		List<VarLimite> varLimiteLista = varlimSer.findAll("2");
		List<CalculoDeVarSwap> calculoDeVarSwapList = cdvss.findByCdInstrumento("2", fecha);
		
		 String producto;
		 double valuacion;
		 double var1;
		 double var2;
		 double var3;
		 double limite=0.0;
		 
		 if(varLimiteLista.size() > 0) {
			 limite= varLimiteLista.get(0).getOperationLimitMoneyMarket();
		 }
		
		for (int i = 0; i < listaTvaluaciones.size(); i++) {
			
			 producto=listaTvaluaciones.get(i).getCdTransaccion();
			 valuacion=listaTvaluaciones.get(i).getValuacion();
			 var1=listaTvaluaciones.get(i).getVar1();
			 var2=listaTvaluaciones.get(i).getVar2();
			 var3=listaTvaluaciones.get(i).getVar3();
			
			
			nivelDetalle.add(new com.phi.proyect.vo.MesaDerivados(producto,valuacion,var1,var2,var3,limite));
			
		}
		

		
		retorno.add(nivelDetalle);
		retorno.add(varLimiteLista);
		retorno.add(calculoDeVarSwapList);
		return retorno;
	}

}
