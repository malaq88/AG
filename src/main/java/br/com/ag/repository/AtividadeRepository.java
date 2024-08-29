package br.com.ag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ag.model.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {
}
