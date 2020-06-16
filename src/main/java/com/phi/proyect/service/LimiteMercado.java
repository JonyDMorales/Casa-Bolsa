package com.phi.proyect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.phi.proyect.repository.LimitesMercadoRepository;

@Service
@Transactional(readOnly = true)
public class LimiteMercado {

	@Autowired
	private LimitesMercadoRepository lmr ;
}
