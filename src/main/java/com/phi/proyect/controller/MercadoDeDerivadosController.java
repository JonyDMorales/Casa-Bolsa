package com.phi.proyect.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.phi.proyect.models.CalculoDeVarSwap;
import com.phi.proyect.models.DeSwap;
import com.phi.proyect.models.DeSwap2;
import com.phi.proyect.models.ResponseTransfer;
import com.phi.proyect.models.Tvaluacionhoy;
import com.phi.proyect.models.Vista;
import com.phi.proyect.service.FuncionesService;
import com.phi.proyect.service.MercadoDeDerivadosService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/mercadoDeDerivadoss")
public class MercadoDeDerivadosController {

	private final FuncionesService fsFuncionesService;
	private final MercadoDeDerivadosService deDerivadosService;

	public MercadoDeDerivadosController(FuncionesService fsFuncionesService,
			MercadoDeDerivadosService deDerivadosService) {
		super();
		this.fsFuncionesService = fsFuncionesService;
		this.deDerivadosService = deDerivadosService;
	}

	@RequestMapping(value = "/swaps", method = RequestMethod.POST)
	public ResponseTransfer insertTvaluacionhoy() {
		List<com.phi.proyect.models.DeSwap2> lista = deDerivadosService.findAllDeSwap();
		String fecha = deDerivadosService.findValue();
		List<Tvaluacionhoy> list = new ArrayList<>();
		List<Vista> listCal = new ArrayList<>();
		int result = 0;
		int result2 = 0;
		Float resultado = (float) 0.0;
		Float resultVar1 = (float) 0.0;
		Float resultVar2 = (float) 0.0;
		Float resultVar3 = (float) 0.0;
		Date date2 = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String fecha2 = dateFormat.format(date2);
		String f = deDerivadosService.findValue();


			if (lista.size() > 0) {
				deDerivadosService.DeleteAll();
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getTpProducto() == 1) {
						// resultado =
						// fsFuncionesService.ValSwapStarting(lista.get(i).getCdTransaccion(),
						// lista.get(i).getNuCurvaDescuento(), fecha);
						// resultVar1 = fsFuncionesService.VaRSwapTiie(lista.get(i).getCdTransaccion(),
						// lista.get(i).getNuCurvaDescuento(), fecha,lista.get(i).getNuFlotante(),3);
						// resultVar2 = fsFuncionesService.VaRSwapTiie(lista.get(i).getCdTransaccion(),
						// lista.get(i).getNuCurvaDescuento(), fecha,lista.get(i).getNuFlotante(),8);
						// resultVar3 = fsFuncionesService.VaRSwapTiie(lista.get(i).getCdTransaccion(),
						// lista.get(i).getNuCurvaDescuento(), fecha,lista.get(i).getNuFlotante(),13);
					} else if (lista.get(i).getTpProducto() == 2) {
						resultado = fsFuncionesService.ValSwapTiie(lista.get(i).getCdTransaccion(),lista.get(i).getNuCurvaDescuento(), fecha, lista.get(i).getNuFlotante());
						if (resultado == (Float) null) {
							resultado = (float) 0.0;
						}
						 resultVar1 = fsFuncionesService.VaRSwapTiie(lista.get(i).getCdTransaccion(),lista.get(i).getNuCurvaDescuento(), fecha,lista.get(i).getNuFlotante(),3);
						 if (resultVar1 == (Float) null) {
							 resultVar1 = (float) 0.0;
							}
						 resultVar2 = fsFuncionesService.VaRSwapTiie(lista.get(i).getCdTransaccion(),lista.get(i).getNuCurvaDescuento(), fecha,lista.get(i).getNuFlotante(),8);
						 if (resultVar2 == (Float) null) {
							 resultVar2 = (float) 0.0;
							}
						 resultVar3 = fsFuncionesService.VaRSwapTiie(lista.get(i).getCdTransaccion(),lista.get(i).getNuCurvaDescuento(), fecha,lista.get(i).getNuFlotante(),13);
						 if (resultVar3 == (Float) null) {
							 resultVar3 = (float) 0.0;
							}
					}
					
					result = deDerivadosService.create(new Tvaluacionhoy(lista.get(i).getCdTransaccion(),resultado,2,f, resultVar1, resultVar2,resultVar3,200));
					
					list = deDerivadosService.findByInsertHistorico(lista.get(i).getCdTransaccion(), fecha2);
					
					if (list.size() == 0) {
						result2 = deDerivadosService.createHistorico(new Tvaluacionhoy(lista.get(i).getCdTransaccion(),resultado,2,f, resultVar1, resultVar2,resultVar3,200));
					}
					
				}

			} else {

				return new ResponseTransfer("No hay swaps que procesar");
			}
			
			listCal = deDerivadosService.selectVista();
			
			if(listCal.size() > 0) {
				deDerivadosService.saveDeVarSwap(new CalculoDeVarSwap("2", f, listCal.get(3).getPl(), listCal.get(8).getPl(), listCal.get(13).getPl()));
			}
			
		return new ResponseTransfer("Success");
		
	}
}
