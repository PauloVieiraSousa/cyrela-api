package com.cyrela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyrela.model.Empreendimento;

public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, Long> {

}
