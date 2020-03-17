package com.phi.proyect.algoritmos;

import com.phi.proyect.models.DiasInhabiles;
import com.phi.proyect.models.VectorPreciosDia;
import com.phi.proyect.service.DiasInhabilesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Algoritmos {

    @Autowired
    DiasInhabilesService diasInhabilesService;

    public Double CalculaPrecio(VectorPreciosDia vector, Date pdFecha, Double pnTasa) {

        Double calculaPrecio = 10.0;
        String lsTV = vector.getTv();
        Double lnTCupon = vector.getCouponRate();
        Date ldIniCupon = vector.getCouponStart();
        Date ldFinCupon = vector.getCouponEnd();
        Date ldFhFin = vector.getExpirationDate();
        String lsDCupon = vector.getDiscountCurve();
        Double lnYiel = vector.getYield();
        Double lnSTasa = vector.getMarketSurcharge();
        Double lnVNominal = vector.getUpdatedNominalValue();
        Integer lnDCupon = 0;
        Integer lnDtrans = 0;
        Double lnIntereses = lnDtrans * lnTCupon * lnVNominal / 36000;
        Double lntdcto = lnYiel;


        System.out.println("Vector: " + vector);
        System.out.println("Fecha pd: " + pdFecha);
        System.out.println("Tasa: " + pnTasa);

        Integer lnArrastre = 0;
        Double lnNuValCupon = 0.0;

        switch (lsTV) {
            // case "M", "S":
            case "M":

                lnDCupon = 182;
                Integer lnDanterior = (int) ((ldFinCupon.getTime() - ldIniCupon.getTime()) / 86400000);
                System.out.println("Anterior: " + lnDanterior);
                System.out.println("Current: " + lnDCupon);
                if (lnDanterior - lnDCupon > 0) {
                    lnArrastre = lnDanterior - lnDCupon;
                }
                System.out.println("Arrastre: " + lnArrastre);
                /*
                do{
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(ldIniCupon);
                    calendar.add(Calendar.DAY_OF_YEAR,lnDCupon + lnArrastre);
                    ldFinCupon = calendar.getTime();
                    Integer lnNuDays = CalculaDays(ldIniCupon, ldFinCupon, lnArrastre);
                    if( ldFinCupon.equals(ldFhFin) ){
                        lnNuValCupon = lnVNominal;
                    } else {
                        lnNuValCupon = 0.0;
                    }
                    Long mili= ldFinCupon.getTime() - pdFecha.getTime();
                    Long days = TimeUnit.DAYS.convert(mili, TimeUnit.MILLISECONDS);
                    calculaPrecio = (lnNuDays * lnTCupon / 360 + lnNuValCupon) / (((long)(1 + pnTasa * lnDCupon / 36000)) ^ ((long)((days) / lnDCupon))) + calculaPrecio;
                    ldIniCupon = ldFinCupon;
                } while(ldIniCupon.before(ldFhFin));
                */


                ldFinCupon = vector.getCouponEnd();
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

    public int buscarTablaDiasInhabiles(Date fecha, String j) {
        List<DiasInhabiles> lista = diasInhabilesService.findByFecha(fecha);
        return lista.get(0).getHabil();
    }
}
