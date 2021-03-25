package com.pedrosv.vacinacao.api.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosv.vacinacao.domain.model.Usuario;
import com.pedrosv.vacinacao.domain.model.Vacina;
import com.pedrosv.vacinacao.domain.repository.VacinaRepository;
import com.pedrosv.vacinacao.domain.service.VacinaService;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {

	@Autowired
	private VacinaService vacinaService;
	
	@Autowired
	private VacinaRepository vacinaRepository;
	
	@GetMapping
	public List<Vacina> listar(){
		return vacinaRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vacina criar(@RequestBody  Map<String, String> payload) {
		
		var email = payload.get("email");
		var nome = payload.get("nome");
		var dataAplicacao = LocalDateTime.parse(payload.get("dataAplicacao"));
	
		
		return vacinaService.criar(nome, email, dataAplicacao);		
		
	}
}
