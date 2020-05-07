package com.phi.proyect.algoritmos;

import com.phi.proyect.models.Logaritmo;
import com.phi.proyect.models.TiposCambios;
import com.phi.proyect.models.VectorPreciosDia;
import com.phi.proyect.service.DiasInhabilesService;
import com.phi.proyect.service.TipoCambiosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class Algoritmos {

	@Autowired
	DiasInhabilesService dis;

	
	@Autowired
	TipoCambiosService tiCamS;
	
	public Double CalculaPrecio(VectorPreciosDia vector, Date pdFecha, Double pnTasa) {
		Double calculaPrecio = 0.0;

		Calendar cpdFecha = Calendar.getInstance();
		cpdFecha.setTime(pdFecha);

		String lsTV = vector.getTv();
		Double lnTCupon = vector.getCouponRate();

		Date ldIniCupon = vector.getCouponStart();
		Calendar cldIniCupon = Calendar.getInstance();
		cldIniCupon.setTime(ldIniCupon);

		Date ldFinCupon = vector.getCouponEnd();
		Calendar cldFinCupon = Calendar.getInstance();
		cldFinCupon.setTime(ldFinCupon);

		Date ldFhFin = vector.getExpirationDate();
		Calendar cldFhFin = Calendar.getInstance();
		cldFhFin.setTime(ldFhFin);

		String lsDCupon = vector.getDiscountCurve();
		Double lnYiel = vector.getYield();
		Double lnSTasa = vector.getMarketSurcharge();
		Double lnVNominal = vector.getUpdatedNominalValue();
		Integer lnDCupon = 0;
		Integer lnDtrans = 0;

		Double lntdcto = lnYiel;

		Integer lnArrastre = 0;
		Double lnNuValCupon = 0.0;

		
		Integer lnDanterior = daysBetween(cldFinCupon, cldIniCupon);
		Double lnIntereses = lnDanterior * lnTCupon * lnVNominal / 36000;
		
		switch (lsTV) {
		// case "M", "S":
		case "M":

			lnDCupon = 182;
			//Integer lnDanterior = daysBetween(cldFinCupon, cldIniCupon);
			//Double lnIntereses = lnDanterior * lnTCupon * lnVNominal / 36000;
			if (lnDanterior - lnDCupon > 0) {
				lnArrastre = lnDanterior - lnDCupon;
			}

			do {
				cldFinCupon = Calendar.getInstance();
				cldFinCupon.setTime(ldIniCupon);
				cldFinCupon.add(Calendar.DAY_OF_YEAR, lnDCupon + lnArrastre);
				ldFinCupon = cldFinCupon.getTime();

				Map<String, Object> calulate = CalculaDays(cldIniCupon, cldFinCupon, lnArrastre);
				Integer lnNuDays = (int) calulate.get("days");
				lnArrastre = (int) calulate.get("arrastre");
				cldFinCupon = (Calendar) calulate.get("pdFhFin");

				if (ldFinCupon.equals(ldFhFin)) {
					lnNuValCupon = lnVNominal;
				} else {
					lnNuValCupon = 0.0;
				}
				double days = (double) daysBetween(cldFinCupon, cpdFecha);
				Double stepOne = lnNuDays * lnTCupon / 360 + lnNuValCupon;
				Double stepTwo = 1 + pnTasa * lnDCupon / 36000;
				Double div = (days / lnDCupon);
				Double stepThree = Math.pow(stepTwo, div);
				calculaPrecio = stepOne / stepThree + calculaPrecio;
				ldIniCupon = cldFinCupon.getTime();
				cldIniCupon.setTime(ldIniCupon);
			} while (ldIniCupon.before(ldFhFin));

			ldFinCupon = vector.getCouponEnd();
			if (ldFinCupon.equals(pdFecha)) {
				calculaPrecio = calculaPrecio - lnIntereses;
			}
			// calculaPrecio *= tipodecambioUDI(pdFecha);// para S
			break;
		case "S":
			lnDCupon = 182;
			
			if (lnDanterior - lnDCupon > 0) {
				lnArrastre = lnDanterior - lnDCupon;
			}

			do {
				cldFinCupon = Calendar.getInstance();
				cldFinCupon.setTime(ldIniCupon);
				cldFinCupon.add(Calendar.DAY_OF_YEAR, lnDCupon + lnArrastre);
				ldFinCupon = cldFinCupon.getTime();

				Map<String, Object> calulate = CalculaDays(cldIniCupon, cldFinCupon, lnArrastre);
				Integer lnNuDays = (int) calulate.get("days");
				lnArrastre = (int) calulate.get("arrastre");
				cldFinCupon = (Calendar) calulate.get("pdFhFin");

				if (ldFinCupon.equals(ldFhFin)) {
					lnNuValCupon = lnVNominal;
				} else {
					lnNuValCupon = 0.0;
				}
				double days = (double) daysBetween(cldFinCupon, cpdFecha);
				Double stepOne = lnNuDays * lnTCupon / 360 + lnNuValCupon;
				Double stepTwo = 1 + pnTasa * lnDCupon / 36000;
				Double div = (days / lnDCupon);
				Double stepThree = Math.pow(stepTwo, div);
				calculaPrecio = stepOne / stepThree + calculaPrecio;
				ldIniCupon = cldFinCupon.getTime();
				cldIniCupon.setTime(ldIniCupon);
			} while (ldIniCupon.before(ldFhFin));

			ldFinCupon = vector.getCouponEnd();
			if (ldFinCupon.equals(pdFecha)) {
				calculaPrecio = calculaPrecio - lnIntereses;
			}
			
			
			 calculaPrecio *= tipodecambioUDI(pdFecha);// para S
			 
			break;

		}
		return calculaPrecio;
	}

	private Map<String, Object> CalculaDays(Calendar pdFhIni, Calendar pdFhFin, Integer pnArrastre) {
		Map<String, Object> calculate = new HashMap<>(3);
		Calendar fh_Original = pdFhFin;

		if (buscarTablaDiasInhabiles(pdFhFin.getTime()) == 1) {
			pdFhFin.add(Calendar.DAY_OF_MONTH, -1);
		}

		pnArrastre = daysBetween(fh_Original, pdFhFin);
		int numberDays = daysBetween(pdFhFin, pdFhIni);

		calculate.put("days", numberDays);
		calculate.put("arrastre", pnArrastre);
		calculate.put("pdFhFin", pdFhFin);

		return calculate;
	}

	public static int daysBetween(Calendar day1, Calendar day2) {
		Calendar dayOne = (Calendar) day1.clone(), dayTwo = (Calendar) day2.clone();

		if (dayOne.get(Calendar.YEAR) == dayTwo.get(Calendar.YEAR)) {
			return Math.abs(dayOne.get(Calendar.DAY_OF_YEAR) - dayTwo.get(Calendar.DAY_OF_YEAR));
		} else {
			if (dayTwo.get(Calendar.YEAR) > dayOne.get(Calendar.YEAR)) {
				Calendar temp = dayOne;
				dayOne = dayTwo;
				dayTwo = temp;
			}
			int extraDays = 0;

			int dayOneOriginalYearDays = dayOne.get(Calendar.DAY_OF_YEAR);

			while (dayOne.get(Calendar.YEAR) > dayTwo.get(Calendar.YEAR)) {
				dayOne.add(Calendar.YEAR, -1);
				extraDays += dayOne.getActualMaximum(Calendar.DAY_OF_YEAR);
			}

			return extraDays - dayTwo.get(Calendar.DAY_OF_YEAR) + dayOneOriginalYearDays;
		}
	}

	public int buscarTablaDiasInhabiles(Date fecha) {
		return dis.findByFecha(fecha);
	}
	
	
	public double tipodecambioUDI(Date fecha) {
		//Date date = Calendar.getInstance().getTime();  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		String strDate = sdf.format(fecha);  
		List<TiposCambios> lista = tiCamS.findVectorPrecioDia(strDate);
		Double cambio = lista.get(0).getCambioUdi();
		
		return cambio;
		
	} 
}
