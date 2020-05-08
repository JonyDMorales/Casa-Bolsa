package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.TiposCambios;
import com.phi.proyect.models.VectorPreciosDia;
import com.phi.proyect.repository.TipoCambiosRepository;
import com.phi.proyect.repository.VectorPreciosDiaRepository;

@Service
@Transactional(readOnly = true)
public class TipoCambiosService {
	@Autowired
	private TipoCambiosRepository tiCam;
	
	public List<TiposCambios> findVectorPrecioDia(String fecha) {
		return this.tiCam.findTipoCambioFecha(fecha);
	}
}
