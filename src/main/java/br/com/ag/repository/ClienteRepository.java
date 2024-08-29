package br.com.ag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ag.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
