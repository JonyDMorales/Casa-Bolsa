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
	public List<LimitesLineas> lista() {
		List<LimitesLineas> lista = lls.findAll();
		return lista;
	} 
	
	
	@GetMapping(value = "limiteUtilizado/{contraparte}")
	public Float limiteUtilizado(@PathVariable("contraparte") String contraparte) {
		
		List<OperacionesMd> lista = ops.find(contraparte);
		Float sumaMultiplicacion=(float) 0.0;
		for(int i =0; i<lista.size(); i++){
			System.out.println("...------....");
			System.out.println(lista.get(i).getIdOperacionesDirecto());
			System.out.println(lista.get(i).getNumeroDeTitulos()*lista.get(i).getPrecio());
			Float multiplicacionRow=(lista.get(i).getNumeroDeTitulos()) * (lista.get(i).getPrecio());
			sumaMultiplicacion = sumaMultiplicacion + (float) multiplicacionRow;
		}
		System.out.println("-----final------");
		System.out.println(sumaMultiplicacion);
		
		List<OperacionesMd> lista2 = ops.find2(contraparte);
		if(lista2.size()>0) {
			Integer idOperacion = lista2.get(0).getIdOperacionesDirecto();
			//System.out.println("log - idOperacion " + idOperacion);
			List<Parametros> listaParametros = ps.findParametro("fecha_menos_uno");
			//System.out.println("log - listaParametros - valorFechaMenos " + valorFechaMenos);
			String valorFechaMenos = listaParametros.get(0).getValorDelParametro();
			System.out.println("log - listaParametros - valorFechaMenos " + valorFechaMenos);
			//String date[] = valorFechaMenos.split("-");
			//Date fecha = new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
			//System.out.println("log - fecha " + fecha);
			/*ry {
				fecha = new SimpleDateFormat("yyyy-MM-dd").parse(valorFechaMenos);
				System.out.println("log - fecha " + fecha);
				DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				String fecha2 = date.format(fecha);
				System.out.println("log - fecha " + fecha);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/ 
			
			//SimpleDateFormat formatter =new SimpleDateFormat("dd-M-yyyy");
			//formatter.setTimeZone(TimeZone.setDefault("UTC"));
			
			
				//@JsonFormat(pattern="dd-M-yyyy")
				LocalDate fechaConverted = LocalDate.parse(valorFechaMenos);
				System.out.println(LocalDate.parse(valorFechaMenos));
				Date diaFinal= java.sql.Date.valueOf(fechaConverted);
				System.out.println(diaFinal);
				
		
			List<ValuacionesMd> listaValuaciones = vs.findValMer(1);
			//System.out.println("log - listaValuaciones " + listaValuaciones.size());
			//Float valMer = Float.parseFloat(listaValuaciones.get(0).getValMer());
			//System.out.println("log - listaValuaciones - valMer " + valMer);
			
			return (sumaMultiplicacion);
			
		}else{
			return sumaMultiplicacion;
		}
		

		
	} 
}
