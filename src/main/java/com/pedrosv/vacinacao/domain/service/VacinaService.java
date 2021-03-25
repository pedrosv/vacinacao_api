package com.pedrosv.vacinacao.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrosv.vacinacao.domain.model.Vacina;
import com.pedrosv.vacinacao.domain.repository.VacinaRepository;

@Service
public class VacinaService {

	@Autowired
	private VacinaRepository vacinarepository;
	
	public Vacina criar(Vacina vacina) {
		
		return vacinarepository.save(vacina);
	}
}
