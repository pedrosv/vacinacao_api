package com.pedrosv.vacinacao.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrosv.vacinacao.domain.model.Usuario;
import com.pedrosv.vacinacao.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario criar(Usuario usuario) {		
		return usuarioRepository.save(usuario);
	}
}
