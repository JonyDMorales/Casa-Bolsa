package com.phi.proyect.service;

import java.util.Date;
import java.util.List;

import com.phi.proyect.repository.DiasInhabilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.DiasInhabiles;

@Service
@Configurable
@Transactional(readOnly = true)
public class DiasInhabilesService {

	@Autowired
	public DiasInhabilesRepository dir;

	@Transactional
	public int findByFecha(Date fecha) {

		List<DiasInhabiles> diasInhabiles = this.dir.findByFecha(fecha);

		if(diasInhabiles.isEmpty()){
			return 0;
		}

		return 1;
	}
}
