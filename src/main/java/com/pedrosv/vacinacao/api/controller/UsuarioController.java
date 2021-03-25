package com.pedrosv.vacinacao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosv.vacinacao.domain.model.Usuario;
import com.pedrosv.vacinacao.domain.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/usuario")
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
}
