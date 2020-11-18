package com.phi.proyect.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mysql.cj.protocol.FullReadInputStream;
import com.phi.proyect.models.Caps;
import com.phi.proyect.models.CdCurvas;
import com.phi.proyect.models.CdInstrumento;
import com.phi.proyect.models.Curvas;
import com.phi.proyect.models.CurvasParametria;
import com.phi.proyect.models.DeCapsfloor;
import com.phi.proyect.models.DeFuturos;
import com.phi.proyect.models.DeSwap;
import com.phi.proyect.models.FlujosCapsfloor;
import com.phi.proyect.models.FlujosSwap;
import com.phi.proyect.models.HCurvas;
import com.phi.proyect.models.HCurvas2;
import com.phi.proyect.models.LimitesMercado;
import com.phi.proyect.models.Parametros;
import com.phi.proyect.models.ResponseTransfer;
import com.phi.proyect.service.CsvService;
import com.phi.proyect.service.MercadoDeDerivadosService;
import com.phi.proyect.service.ParametrosService;
import com.phi.proyect.service.VarOperacionesMdService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/archivos")
public class CsvController {

	private final CsvService csvService;
	private final ParametrosService params;
	private final MercadoDeDerivadosService deDerivadosService;

	public CsvController(CsvService csvService, ParametrosService params,
			MercadoDeDerivadosService deDerivadosService) {
		super();
		this.csvService = csvService;
		this.params = params;
		this.deDerivadosService = deDerivadosService;
	}

	@RequestMapping(value = "/Column", method = RequestMethod.POST)
	public List<Object> getColumnasFilas() {
		
		List<Object> retorno = new ArrayList <Object>();
		List<CurvasParametria> response = csvService.getCurvasParametria();
		
		String fecha = deDerivadosService.findValueDate();

		retorno.add(response);
		retorno.add(fecha);

		return retorno;
	}

	@RequestMapping(value = "/csv", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Caps> archivoUpload(@RequestBody ObjectNode obj) {
		Caps caps = new Caps();
		caps.setCdTransaccion(obj.get("0").asText());
		caps.setCdInstrumento(obj.get("1").asInt());
		caps.setFhInicio(obj.get("2").asText());
		caps.setFhFin(obj.get("3").asText());
		caps.setNuCurvaDescuento(obj.get("4").asInt());
		caps.setNuCurvaVolatilidad(obj.get("5").asInt());
		caps.setNuStrike(obj.get("6").asDouble());
		caps.setTc(obj.get("7").asDouble());
		caps.setNuNominal(obj.get("8").asInt());
		caps.setNuConvencion(obj.get("9").asInt());
		return new ResponseEntity<>(this.csvService.create(caps), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/hcurvas", method = RequestMethod.POST)
	public ResponseTransfer uploadHCurvas(@RequestBody ObjectNode obj) {
		double[] array = new double[107];
		int t = 2;
		int cdCurva = obj.get("1").asInt();
		List<HCurvas2> ultimo = csvService.getUltimoRegistro(cdCurva);
		String fecha = ultimo.get(0).getFhDate();
		int del = csvService.deleteUltimoRegistro(fecha, cdCurva);		

		for (int i = 0; i < array.length; i++) {
			String tConvert = "" + t + "";
			if (obj.get(tConvert) != null) {
				array[i] = obj.get(tConvert).asDouble();
			} else {
				array[i] = 0.0;
			}
			t++;
		}

		String fecha2 = deDerivadosService.findValue();
		int eliminar = csvService.deleteHcurvas(fecha2);
		String response = "Error";
		int resp = csvService.createCurvasNuevo(array, cdCurva, fecha2);
		if (resp == 1) {
			response = "Insertado Correctamente";
		}

		return new ResponseTransfer(response);
	}

	
	
	
	@RequestMapping(value = "/deleteCurvas", method = RequestMethod.POST)
	public ResponseTransfer deleteAllCurvas() {
		String response = "Error";
		int a = csvService.deleteAllCurvas();

		if (a == 0) {
	      	response = "Success";		
		}
		return new ResponseTransfer(response);
	}
	
	
	@RequestMapping(value = "/curvas", method = RequestMethod.POST)
	@ResponseBody
	public ResponseTransfer uploadCurvas(@RequestBody ObjectNode obj) {

		List<CdCurvas> lista = csvService.findByCdCurva(obj.get("1").asInt());
		if (lista.size() > 0) {
			String fecha2 = deDerivadosService.findValue();
			Curvas curvas = new Curvas();
			curvas.setFkCdCurva(obj.get("1").asInt());
			curvas.setFhDate(fecha2);
			curvas.setNuNodo(obj.get("2").asInt());
			curvas.setValor(obj.get("3").asDouble(0));
			String response = "Error";
			int resp = csvService.saveCurvas(curvas);
			if (resp == 1) {
				response = "Insertado Correctamente";
			}
			return new ResponseTransfer(response);
		} else {
			return new ResponseTransfer("No se encontro el valor " + obj.get("1").asInt()
					+ " tiene que hacer el registro primero en cd_curvas");
		}
	}

	@RequestMapping(value = "/decapsfloor", method = RequestMethod.POST)
	@ResponseBody
	public ResponseTransfer uploadDeCapsFloor(@RequestBody ObjectNode obj) {

		List<CdInstrumento> lista = csvService.findByIdIntrumento(obj.get("1").asInt());
		if (lista.size() > 0) {
			List<CdCurvas> lista2 = csvService.findByCdCurva(obj.get("4").asInt());
			if (lista2.size() > 0) {
				List<CdCurvas> lista3 = csvService.findByCdCurva(obj.get("5").asInt());
				if (lista3.size() > 0) {

					List<DeCapsfloor> lista4 = csvService.findByCdTransaccion(obj.get("0").asText());

					if (lista4.size() > 0) {
						return new ResponseTransfer("El valor " + obj.get("0").asInt() + " ya se encuentra registrado");
					} else {
						DeCapsfloor deCapsfloor = new DeCapsfloor();
						deCapsfloor.setCdTransaccion(obj.get("0").asText());
						deCapsfloor.setCdInstrumento(obj.get("1").asInt());
						deCapsfloor.setFhInicio(obj.get("2").asText());
						deCapsfloor.setFhFin(obj.get("3").asText());
						deCapsfloor.setNuCurvaDescuento(obj.get("4").asInt());
						deCapsfloor.setNuCurvaVolatilidad(obj.get("5").asInt());
						deCapsfloor.setNuStrike(obj.get("6").asDouble());
						deCapsfloor.setTc(obj.get("7").asDouble());
						deCapsfloor.setNuNominal(obj.get("8").asInt());
						deCapsfloor.setNuConvencion(obj.get("9").asInt());

						String response = "Error";
						int resp = csvService.saveDeCapsFloor(deCapsfloor);
						if (resp == 1) {
							response = "Insertado Correctamente";
						}

						return new ResponseTransfer(response);

					}

				} else {
					return new ResponseTransfer("No se encontro el valor " + obj.get("5").asInt()
							+ " tiene que hacer el registro primero en cd_curvas");
				}
			} else {
				return new ResponseTransfer("No se encontro el valor " + obj.get("4").asInt()
						+ " tiene que hacer el registro primero en cd_curvas");
			}
		} else {
			return new ResponseTransfer("No se encontro el valor " + obj.get("1").asInt()
					+ " tiene que hacer el registro primero en cd_instrumento");
		}
	}

	@RequestMapping(value = "/flujoscapsfloor", method = RequestMethod.POST)
	@ResponseBody
	public ResponseTransfer uploadFlujosCapsFloor(@RequestBody ObjectNode obj) {
		List<DeCapsfloor> lista = csvService.findByCdTransaccion(obj.get("0").asText());

		if (lista.size() > 0) {
			FlujosCapsfloor flujosCapsfloor = new FlujosCapsfloor();
			flujosCapsfloor.setCdTransaccion(obj.get("0").asText());
			flujosCapsfloor.setNuPago(obj.get("1").asInt());
			flujosCapsfloor.setFhPago(obj.get("2").asText());
			flujosCapsfloor.setNuMontoPago(obj.get("3").asDouble());
			flujosCapsfloor.setNuPlazoCupon(obj.get("4").asInt());
			flujosCapsfloor.setNuTasaVigente(obj.get("5").asDouble());
			flujosCapsfloor.setCdActivo(obj.get("6").asInt());

			String response = "Error";
			int resp = csvService.saveFlujosCaps(flujosCapsfloor);
			if (resp == 1) {
				response = "Insertado Correctamente";
			}
			return new ResponseTransfer(response);

		} else {
			return new ResponseTransfer(
					"No se encontro el valor " + obj.get("0").asInt() + " tiene que hacer el registro en de_capsfloor");
		}
	}
	
	
	@RequestMapping(value = "/deleteSwap", method = RequestMethod.POST)
	public ResponseTransfer eliminarSwapFlujos() {
		String response = "Error";
		int a =  csvService.deleteFlujosSwap();
		if (a == 0) {
				int b = csvService.deleteDeSwap();
			if (b == 0) {
				response = "Success";		
			}
		}
		return new ResponseTransfer(response);
	}
	@RequestMapping(value = "/deswap", method = RequestMethod.POST)
	@ResponseBody
	public ResponseTransfer uploadDeSwap(@RequestBody ObjectNode obj) {
		List<DeSwap> lista = csvService.findByTransaccion(obj.get("1").asText());
		if (lista.size() > 0) {
			return new ResponseTransfer("El valor " + obj.get("1").asText() + " ya se encuentra registrado");
		} else {
			List<FlujosSwap> register = csvService.getResultadosFlujosSwap();
			if (register.size() > 0) {

				for (int j = 0; j < register.size(); j++) {
					//csvService.deleteFlujosSwap(register.get(j).getCdTransaccion());
				}
			}
			DeSwap deSwap = new DeSwap();
			deSwap.setCdTransaccion(obj.get("1").asText());
			deSwap.setCdInstrumento(obj.get("2").asInt());
			deSwap.setFhInicio(obj.get("3").asText());
			deSwap.setFhFin(obj.get("4").asText());
			deSwap.setNuCurvaDescuento(obj.get("5").asInt());
			deSwap.setCurvaFlot(obj.get("6").asInt());
			deSwap.setNuFija(obj.get("7").asDouble());
			deSwap.setNuFlotante(obj.get("8").asInt());
			deSwap.setNuNominal(obj.get("9").asInt());
			deSwap.setTcBanco(obj.get("10").asDouble());
			deSwap.setTcCliente(obj.get("11").asDouble());
			deSwap.setCdBcoRecibe(obj.get("12").asInt());
			deSwap.setNuConvencion(obj.get("13").asDouble());
			deSwap.setTpProducto(obj.get("14").asInt());
			deSwap.setTpTransaccion(obj.get("15").asInt());
			deSwap.setTpDescuento(obj.get("16").asInt());

			String response = "Error";
			int resp = csvService.saveDeSwap(deSwap);
			if (resp == 1) {
				response = "Insertado Correctamente";
			}
			return new ResponseTransfer(response);

		}
	}

	@RequestMapping(value = "/flujosSwap", method = RequestMethod.POST)
	@ResponseBody
	public ResponseTransfer uploadFlujosSwap(@RequestBody ObjectNode obj) {
		//csvService.deleteFlujosSwap();
		List<DeSwap> lista = csvService.findByTransaccion(obj.get("0").asText());
		if (lista.size() > 0) {
			FlujosSwap flujosSwap = new FlujosSwap();
			flujosSwap.setCdTransaccion(obj.get("0").asText());
			flujosSwap.setNuPago(obj.get("1").asInt());
			flujosSwap.setFhPago(obj.get("2").asText());
			flujosSwap.setNuMontoPago(obj.get("3").asDouble());
			flujosSwap.setNuPlazoCupon(obj.get("4").asInt());
			flujosSwap.setNuTasaVigente(obj.get("5").asDouble());
			flujosSwap.setCdActivo(obj.get("6").asInt());
			flujosSwap.setFh_Pago_b(obj.get("7").asText());
			flujosSwap.setNu_Monto_Pago_b(obj.get("8").asDouble());
			flujosSwap.setNu_PlazoCupon_b(obj.get("9").asInt());

			String response = "Error";
			int resp = csvService.saveFlujosSwap(flujosSwap);
			if (resp == 1) {
				response = "Insertado Correctamente";
			}
			return new ResponseTransfer(response);

		} else {
			return new ResponseTransfer(
					"No se encontro el valor " + obj.get("0").asInt() + " tiene que hacer el registro en de_swap");
		}
	}

	@RequestMapping(value = "/deFuturos", method = RequestMethod.POST)
	@ResponseBody
	public ResponseTransfer uploadDeFuturos(@RequestBody ObjectNode obj) {
		List<DeFuturos> lista = csvService.findByCodigoDeTransaccion(obj.get("0").asInt());
		if (lista.size() > 0) {
			return new ResponseTransfer("El valor " + obj.get("0").asInt() + " ya se encuentra registrado");
		} else {
			DeFuturos deFuturos = new DeFuturos();
			deFuturos.setCodigoDeTransaccion(obj.get("0").asInt());
			deFuturos.setCdInstrumento(obj.get("1").asInt());
			deFuturos.setFechaInicio(obj.get("2").asText());
			deFuturos.setFechaFin(obj.get("3").asText());
			deFuturos.setUnCurvaLocal(obj.get("4").asInt());
			deFuturos.setUnCurvaForanea(obj.get("5").asInt());
			deFuturos.setUnCurvaIndice(obj.get("6").asInt());
			deFuturos.setNuPactado(obj.get("7").asDouble());
			deFuturos.setUnContratos(obj.get("8").asInt());
			deFuturos.setUnPosicion(obj.get("9").asInt());
			deFuturos.setUnPlazo(obj.get("10").asInt());
			deFuturos.setConvencion(obj.get("11").asInt());
			String response = "Error";
			DeFuturos resp = csvService.createDeFuturos(deFuturos);
			if (resp.getCodigoDeTransaccion() == obj.get("0").asInt()) {
				response = "Insertado Correctamente";
			}
			return new ResponseTransfer(response);
		}
	}
}
