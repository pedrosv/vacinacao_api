package com.pedrosv.vacinacao.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrosv.vacinacao.domain.exception.DomainException;
import com.pedrosv.vacinacao.domain.model.Usuario;
import com.pedrosv.vacinacao.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario criar(Usuario usuario) {
		
		if(usuarioRepository.existsByCpf(usuario.getCpf())) {
			throw new DomainException("Ja possui um usuario com esse CPF");
		}
		
		if(usuarioRepository.existsByEmail(usuario.getEmail())) {
			throw new DomainException("Ja possui um usuario com esse email");
		}
		
		return usuarioRepository.save(usuario);
	}
}
