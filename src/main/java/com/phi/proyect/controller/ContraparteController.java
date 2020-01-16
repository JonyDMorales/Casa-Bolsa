package com.phi.proyect.controller;


import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.TimeZone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.phi.proyect.models.Divisas;
import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.OperacionesMd;
import com.phi.proyect.models.Parametros;
import com.phi.proyect.models.ValuacionesMd;
import com.phi.proyect.service.LimitesLineasService;
import com.phi.proyect.service.OperacionService;
import com.phi.proyect.service.ParametrosService;
import com.phi.proyect.service.ValuacionesMdService;

@RestController
@RequestMapping("/semaforosalertas")
public class ContraparteController {

	private final LimitesLineasService lls;
	private final OperacionService ops;
	private final ParametrosService ps;
	private final ValuacionesMdService vs;
	
	public ContraparteController(LimitesLineasService lls,OperacionService ops, ParametrosService ps, ValuacionesMdService vs) {
		super();
		this.lls = lls;
		this.ops = ops;
		this.ps = ps;
		this.vs = vs;
	}
	
	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView();
		
		
		mav.addObject("titulo", "Semaforos y Alertas");
		mav.setViewName("semaforosalertas");
		return mav;
	}
	@GetMapping(value = "lista")
	public List<com.phi.proyect.vo.LimitesLineas> lista() {
		
		com.phi.proyect.vo.LimitesLineas limite = new com.phi.proyect.vo.LimitesLineas();
		List<com.phi.proyect.vo.LimitesLineas> listReturn = new ArrayList<com.phi.proyect.vo.LimitesLineas>();

		List<LimitesLineas> lista = lls.findAll();
		for (int i = 0; i < lista.size(); i++) {
			
			float sumaLimite  = limiteUtilizado(lista.get(i).getContraparte());

			listReturn.add(new com.phi.proyect.vo.LimitesLineas(lista.get(i).getContraparte(), sumaLimite,lista.get(i).getGlobalLimit(),lista.get(i).getUsuario()));
		}
		return listReturn;
	} 
	
	
	//@GetMapping(value = "limiteUtilizado/{contraparte}")
	public Float limiteUtilizado(String contraparte) {
		
		List<OperacionesMd> lista = ops.find(contraparte);
		Float sumaMultiplicacion=(float) 0.0;
		for(int i =0; i<lista.size(); i++){
			Float multiplicacionRow=(lista.get(i).getNumeroDeTitulos()) * (lista.get(i).getPrecio());
			sumaMultiplicacion = sumaMultiplicacion + (float) multiplicacionRow;
		}
		
		List<OperacionesMd> lista2 = ops.find2(contraparte);
		if(lista2.size()>0) {
			Integer idOperacion = lista2.get(0).getIdOperacionesDirecto();
			List<Parametros> listaParametros = ps.findParametro("fecha_menos_uno");
			String valorFechaMenos = listaParametros.get(0).getValorDelParametro();

		
			List<ValuacionesMd> listaValuaciones = vs.findValMer(idOperacion,valorFechaMenos);

			
			if(listaValuaciones.size() > 0) {
				
				sumaMultiplicacion += Float.parseFloat(listaValuaciones.get(0).getValMer());

			}
			
			return (sumaMultiplicacion);
			
		}else{
			return sumaMultiplicacion;
		}
		

		
	} 
}
