package com.pedrosv.vacinacao.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosv.vacinacao.domain.model.Usuario;
import com.pedrosv.vacinacao.domain.repository.UsuarioRepository;
import com.pedrosv.vacinacao.domain.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@Valid @RequestBody Usuario usuario) {
		return usuarioService.criar(usuario);
	}
	
	
}
