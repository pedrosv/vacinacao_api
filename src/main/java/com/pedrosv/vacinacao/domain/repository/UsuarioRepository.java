package com.pedrosv.vacinacao.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrosv.vacinacao.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByEmail(String email);
	Usuario findByCpf(String cpf);
	
	boolean existsByEmail(String email);
	boolean existsByCpf(String cpf);

}
