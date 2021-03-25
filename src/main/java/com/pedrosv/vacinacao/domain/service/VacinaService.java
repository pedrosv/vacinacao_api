package com.pedrosv.vacinacao.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrosv.vacinacao.domain.exception.DomainException;
import com.pedrosv.vacinacao.domain.model.Usuario;
import com.pedrosv.vacinacao.domain.model.Vacina;
import com.pedrosv.vacinacao.domain.repository.UsuarioRepository;
import com.pedrosv.vacinacao.domain.repository.VacinaRepository;

@Service
public class VacinaService {

	@Autowired
	private VacinaRepository vacinarepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	

	public Vacina criar(String nome, String email, LocalDateTime dataAplicacao) {
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new DomainException("Usuário nao encontrado"));
		
		Vacina vacina = new Vacina();
		vacina.setDataAplicacao(dataAplicacao);
		vacina.setNome(nome);
		vacina.setUsuario(usuario);
		
		return vacinarepository.save(vacina);
	}
}
