package br.com.ag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ag.model.Projeto;
import br.com.ag.util.Status;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

	List<Projeto> findByClienteId(int clienteId);

	List<Projeto> findByStatus(Status status);

}
