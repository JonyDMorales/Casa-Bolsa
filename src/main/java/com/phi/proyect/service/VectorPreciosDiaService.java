package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.LimitesLineas;
import com.phi.proyect.models.VectorPreciosDia;
import com.phi.proyect.repository.VectorPreciosDiaRepository;

@Service
@Transactional(readOnly = true)
public class VectorPreciosDiaService {

	@Autowired
	private VectorPreciosDiaRepository vpd;

	public List<VectorPreciosDia> findVectorPrecioDia(String producto) {
		return this.vpd.findVectorPrecioDia(producto);
	}

	public List<VectorPreciosDia> findAll() {
		return vpd.findAll();
	}

}
