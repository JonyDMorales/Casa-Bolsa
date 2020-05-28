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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.phi.proyect.models.DiasInhabiles;
import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.Logaritmo;
import com.phi.proyect.models.OperacionesMd;
import com.phi.proyect.models.ValuacionesMd;
import com.phi.proyect.models.VarLimite;
import com.phi.proyect.models.VarOperacionesMd;
import com.phi.proyect.models.Vector;
import com.phi.proyect.models.VectorPreciosDia;
import com.phi.proyect.service.DiasInhabilesService;
import com.phi.proyect.service.LogaritmoService;
import com.phi.proyect.service.OperacionService;
import com.phi.proyect.service.ValuacionesMdService;
import com.phi.proyect.service.VarLimiteService;
import com.phi.proyect.service.VarOperacionesMdService;
import com.phi.proyect.service.VectorPreciosDiaService;
import com.phi.proyect.service.VectorService;
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
	
	@Autowired
	Algoritmos algoritmos;

	public LogaritmoController(LogaritmoService log, VectorService vecSer, VectorPreciosDiaService vecpds,
			DiasInhabilesService dis, VarLimiteService varlimSer, ValuacionesMdService vs,OperacionService ops,VarOperacionesMdService vaOpMdSer) {
		super();
		this.log = log;
		this.vecSer = vecSer;
		this.vecpds = vecpds;
		this.dis = dis;
		this.varlimSer = varlimSer;
		this.vs = vs;
		this.ops = ops;
		this.vaOpMdSer = vaOpMdSer;
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
		 varOperacionesMd.setParam1(param1);
		 varOperacionesMd.setParam2(param2);
		 varOperacionesMd.setParam3(param3);
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
				}
				
				if(lista4.size() > 0) {
					valor1=lista4.get(0).getParam1();
					valor2=lista4.get(0).getParam2();
					valor3=lista4.get(0).getParam3();
				}
				multi = valor * Double.parseDouble(lista3.get(0).getTitulos());
				listReturn.add(new com.phi.proyect.vo.MesadeDinero(lista.get(i).getIdValmerPriceVector(),
						lista.get(i).getIssue(), lista2.get(0).getLimite(), valor, multi,valor1,valor2,valor3));
			}
		}
		return listReturn;
	}

}
