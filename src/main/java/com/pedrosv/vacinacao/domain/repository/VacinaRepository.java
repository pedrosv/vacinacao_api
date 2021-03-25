package com.pedrosv.vacinacao.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrosv.vacinacao.domain.model.Vacina;

@Repository
public interface VacinaRepository  extends JpaRepository<Vacina, Long>{

}
