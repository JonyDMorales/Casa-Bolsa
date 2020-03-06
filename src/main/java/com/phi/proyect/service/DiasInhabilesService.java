package com.phi.proyect.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.DiasInhabiles;
import com.phi.proyect.models.Divisas;
import com.phi.proyect.repository.DiasInhabilesRepository;

@Service
@Transactional(readOnly = true)
public class DiasInhabilesService {

    @Autowired
	private DiasInhabilesRepository di;
	
	public List<DiasInhabiles> findByFecha(Date fecha) {
		return this.di.findByFecha(fecha);
	}
}
