package com.phi.proyect.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.ranges.Range;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.Logaritmo;
import com.phi.proyect.models.Vector;
import com.phi.proyect.models.VectorPreciosDia;
import com.phi.proyect.service.LogaritmoService;
import com.phi.proyect.service.VectorPreciosDiaService;
import com.phi.proyect.service.VectorService;

@RestController
@RequestMapping("/logaritmo")
public class LogaritmoController {

	private final LogaritmoService log;
	private final VectorService vecSer;
	private final VectorPreciosDiaService vecpds;

	public LogaritmoController(LogaritmoService log, VectorService vecSer,VectorPreciosDiaService vecpds) {
		super();
		this.log = log;
		this.vecSer = vecSer;
		this.vecpds = vecpds;
	}

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("titulo", "Logaritmo");
		mav.setViewName("logaritmo");
		// lista("IM_BPAG28_191121");
		return mav;
	}

	@RequestMapping(path = "getParametros/",method = RequestMethod.GET,consumes = "application/json")
	public List<com.phi.proyect.vo.Logaritmo> lista(@PathVariable("logaritmo") String descripcion,@PathVariable("fecha") Date fecha) {
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
					listReturn.add(new com.phi.proyect.vo.Logaritmo(logaritmo));
					cont++;
				}
				return listReturn;
			}
			return listReturn;
		}
		return listReturn;
	}

	public Double CalculaPrecio(String psEmision, Date pdFecha, Double pnTasa) {

		Double calculaPrecio = 0.0;

		String lsTV = (String) buscarEnBaseDeDatos(psEmision, "tv"); // col('tv') vector_de_precios_dia
		Double lnTCupon = (Double) buscarEnBaseDeDatos(psEmision, "cupon_rate");// col('cupon_rate')
																				// vector_de_precios_dia
		Date ldIniCupon = (Date) buscarEnBaseDeDatos(psEmision, "cupon_start");// col('cupon_start')
																				// vector_de_precios_dia
		Date ldFinCupon = (Date) buscarEnBaseDeDatos(psEmision, "cupon_end");// col('cupon_end') vector_de_precios_dia
		Date ldFhFin = (Date) buscarEnBaseDeDatos(psEmision, "expiration_date"); // col('expiration_date')
																					// vector_de_precios_dia
		String lsDCupon = (String) buscarEnBaseDeDatos(psEmision, "discount_curve");// col('discount_curve')
																					// vector_de_precios_dia
		Double lnYiel = (Double) buscarEnBaseDeDatos(psEmision, "yield"); // col('yield') vector_de_precios_dia
		Double lnSTasa = (Double) buscarEnBaseDeDatos(psEmision, "market_surcharge");// col('market_surcharge')
																						// vector_de_precios_dia
		Double lnVNominal = (Double) buscarEnBaseDeDatos(psEmision, "updated_nominal_value");// col('updated_nominal_value')
																								// vector_de_precios_dia
		Integer lnDCupon = 0;
		Integer lnDtrans = 0;
		Double lnIntereses = lnDtrans * lnTCupon * lnVNominal / 36000;
		Double lntdcto = lnYiel;

		Integer lnArrastre = 0;
		Double lnNuValCupon = 0.0;

		switch (lsTV) {
		case "M", "S":
			lnDCupon = 182;
			Integer lnDanterior = (int) ((ldFinCupon.getTime() - ldIniCupon.getTime()) / 86400000);
			if (lnDanterior - lnDCupon > 0) {
				lnArrastre = lnDanterior - lnDCupon;
			}

			do {
				// ldFinCupon = ldIniCupon + lnDCupon + lnArrastre;//no sabemos que onda quedo
				// como constante
				// ldFinCupon = '2020-01-03';
				Integer lnNuDays = CalculaDays(ldIniCupon, ldFinCupon, lnArrastre);
				if (ldFinCupon == ldFhFin) {
					lnNuValCupon = lnVNominal;
				} else {
					lnNuValCupon = 0.0;
				}
//	                calculaPrecio = (lnNuDays * lnTCupon / 360 + lnNuValCupon) / ((1 + pnTasa * lnDCupon / 36000) ^ ((ldFinCupon.getTime() - pdFecha.getTime()) / lnDCupon)) + calculaPrecio;
				ldIniCupon = ldFinCupon;
			} while (ldIniCupon.getTime() < ldFhFin.getTime());

			ldFinCupon = (Date) buscarEnBaseDeDatos(psEmision, "cupon_end");// col('cupon_end') vector_de_precios_dia
			if (ldFinCupon == pdFecha) {
				calculaPrecio = calculaPrecio - lnIntereses;
			}

			break;

		}
		return calculaPrecio;
	}

	private Integer CalculaDays(Date pdFhIni, Date pdFhFin, Integer pnArrastre) {

		Date fh_Original = pdFhFin;
		// String nb_Fecha = pdFhFin;
		if (buscarTablaDiasInhabiles(pdFhFin, "habil") == 1) { // col('habil') dias_inhabiles
			pdFhFin = restarDiasFecha(pdFhFin, -1);
			pnArrastre = (int) ((fh_Original.getTime() - pdFhFin.getTime()) / 86400000);
		}

		return (int) ((pdFhFin.getTime() - pdFhIni.getTime()) / 86400000);
	}

	public Date restarDiasFecha(Date fecha, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de días a añadir, o restar en caso de días<0
		return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
	}

	public Object buscarEnBaseDeDatos(String producto, String columna) {
		List<VectorPreciosDia> lista = vecpds.findVectorPrecioDia(columna, producto);
		
		
		return lista;
	}

	public int buscarTablaDiasInhabiles(Date h, String j) {
		return 1;
	}

}
