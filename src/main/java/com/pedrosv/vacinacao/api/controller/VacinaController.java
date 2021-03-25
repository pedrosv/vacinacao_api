package com.pedrosv.vacinacao.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosv.vacinacao.domain.model.Vacina;
import com.pedrosv.vacinacao.domain.service.VacinaService;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {

	@Autowired
	private VacinaService vacinaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vacina criar(@RequestBody Vacina vacina) {
		return vacinaService.criar(vacina);
	}
}
