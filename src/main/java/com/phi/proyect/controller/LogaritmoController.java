package com.phi.proyect.controller;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.phi.proyect.algoritmos.Algoritmos;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.phi.proyect.models.DiasInhabiles;
import com.phi.proyect.models.Logaritmo;
import com.phi.proyect.models.VarLimite;
import com.phi.proyect.models.Vector;
import com.phi.proyect.models.VectorPreciosDia;
import com.phi.proyect.service.DiasInhabilesService;
import com.phi.proyect.service.LogaritmoService;
import com.phi.proyect.service.VarLimiteService;
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

	public LogaritmoController(LogaritmoService log, VectorService vecSer, VectorPreciosDiaService vecpds,
			DiasInhabilesService dis,VarLimiteService varlimSer) {
		super();
		this.log = log;
		this.vecSer = vecSer;
		this.vecpds = vecpds;
		this.dis = dis;
		this.varlimSer = varlimSer;
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
		List<Logaritmo> lista = log.findByDescripcion(descripcion);
		List<com.phi.proyect.vo.Logaritmo> listReturn = new ArrayList<com.phi.proyect.vo.Logaritmo>();
		if (!lista.isEmpty()) {
			String[] desc = lista.get(0).getValorDelParametro().split("\\|");
			if (desc[1].equals("market_surcharge")) {
				List<Vector> lista2 = vecSer.findIssue(lista.get(0).getDescripcion(), Integer.parseInt(desc[0]));
				int cont = 1;
				for (int i = 0; i < lista2.size() - 1; i++) {
					Float logaritmo = (float) 0.0;
					logaritmo = (float) Math
							.log(lista2.get(i).getMarketSurcharge() / lista2.get(cont).getMarketSurcharge());

					if (i == 0) {
						Date date1;
						try {
							date1 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
							//System.out.println(CalculaPrecio(descripcion, date1, logaritmo + tasa));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

					listReturn.add(new com.phi.proyect.vo.Logaritmo(logaritmo));
					cont++;
				}
				return listReturn;
			}
			return listReturn;
		}
		return listReturn;
	}


	@PostMapping ("/calcular/precio")
	public double calcular(@RequestBody ObjectNode obj) {
		Algoritmos algoritmos = new Algoritmos();
		String descripcion = obj.get("descripcion").asText();
		String fecha = obj.get("fecha").asText();
		Double tasa = obj.get("tasa").asDouble();

		List<VectorPreciosDia> lista = vecpds.findVectorPrecioDia(descripcion);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return algoritmos.CalculaPrecio(lista.get(0),sdf.parse(fecha, new ParsePosition(0)),tasa);

	}
	
	
	@GetMapping(value= "mesaDinero/")
	public List<MesadeDinero> mesaDinero(@PathVariable("tipoEnvio") Integer tipoEnvio){
		List<com.phi.proyect.vo.MesadeDinero> listReturn = new ArrayList<com.phi.proyect.vo.MesadeDinero>();
		List<VectorPreciosDia> lista = vecpds.findAll();
		for(int i = 0; i < lista.size(); i++) {
			List<VarLimite> lista2 = varlimSer.findAll(lista.get(i).getIssue());
			if (lista2.size() > 0) {
				listReturn.add(new com.phi.proyect.vo.MesadeDinero(lista.get(i).getIdValmerPriceVector(),lista.get(i).getIssue(),lista2.get(0).getLimite()));
			}
		}
		return listReturn;
	}

}
