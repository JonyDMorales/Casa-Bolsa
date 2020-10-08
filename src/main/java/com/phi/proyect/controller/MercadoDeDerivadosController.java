package com.phi.proyect.controller;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
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
import com.phi.proyect.models.ResponseTransfer;
import com.phi.proyect.models.Tvaluacionhoy;
import com.phi.proyect.service.FuncionesService;
import com.phi.proyect.service.MercadoDeDerivadosService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/mercadoDeDerivadoss")
public class MercadoDeDerivadosController {

	private final FuncionesService fsFuncionesService;
	private final MercadoDeDerivadosService deDerivadosService;
	
	public MercadoDeDerivadosController(FuncionesService fsFuncionesService, MercadoDeDerivadosService deDerivadosService) {
		super();
		this.fsFuncionesService = fsFuncionesService;
		this.deDerivadosService = deDerivadosService;
	}
	
	@RequestMapping(value = "/swaps", method = RequestMethod.POST)
	public ResponseTransfer insertTvaluacionhoy() {
		List<com.phi.proyect.models.DeSwap2> lista = deDerivadosService.findAllDeSwap();
		String value = deDerivadosService.findValue();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = sdf.parse(value, new ParsePosition(0));
		
		double resultado = 0.0;
		double resultVar1 = 0.0;
		double resultVar2 = 0.0;
		double resultVar3 = 0.0;
		
		if (lista.size() > 0) {
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTpProducto() == 1) {
					resultado = fsFuncionesService.ValSwapTiieFijo(lista.get(i).getCdTransaccion(), lista.get(i).getNuCurvaDescuento(), fecha,lista.get(i).getNuFlotante());
					resultVar1 = fsFuncionesService.VaRSwapTiieFijo(lista.get(i).getCdTransaccion(), lista.get(i).getNuCurvaDescuento(), fecha,lista.get(i).getNuFlotante(),3);
					resultVar2 = fsFuncionesService.VaRSwapTiieFijo(lista.get(i).getCdTransaccion(), lista.get(i).getNuCurvaDescuento(), fecha,lista.get(i).getNuFlotante(),8);
					resultVar3 = fsFuncionesService.VaRSwapTiieFijo(lista.get(i).getCdTransaccion(), lista.get(i).getNuCurvaDescuento(), fecha,lista.get(i).getNuFlotante(),13);
				}else if(lista.get(i).getTpProducto() == 2) {
					resultado = fsFuncionesService.ValSwapTiieFijo(lista.get(i).getCdTransaccion(), lista.get(i).getNuCurvaDescuento(), fecha,lista.get(i).getNuFlotante());
					resultVar1 = fsFuncionesService.VaRSwapTiieFijo(lista.get(i).getCdTransaccion(), lista.get(i).getNuCurvaDescuento(), fecha,lista.get(i).getNuFlotante(),3);
					resultVar2 = fsFuncionesService.VaRSwapTiieFijo(lista.get(i).getCdTransaccion(), lista.get(i).getNuCurvaDescuento(), fecha,lista.get(i).getNuFlotante(),8);
					resultVar3 = fsFuncionesService.VaRSwapTiieFijo(lista.get(i).getCdTransaccion(), lista.get(i).getNuCurvaDescuento(), fecha,lista.get(i).getNuFlotante(),13);
				}
				deDerivadosService.createCalculo(new CalculoDeVarSwap(lista.get(i).getCdTransaccion(), fecha, resultVar1, 3));
				deDerivadosService.createCalculo(new CalculoDeVarSwap(lista.get(i).getCdTransaccion(), fecha, resultVar2, 8));
				deDerivadosService.createCalculo(new CalculoDeVarSwap(lista.get(i).getCdTransaccion(), fecha, resultVar3, 13));
				deDerivadosService.create(new Tvaluacionhoy(lista.get(i).getCdTransaccion(), resultado));
				
			}
			
			return new ResponseTransfer("Success");
		} else {

			return new ResponseTransfer("Error");
		}
	}
}
