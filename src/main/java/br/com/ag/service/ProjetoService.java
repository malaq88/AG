package br.com.ag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ag.model.Cliente;
import br.com.ag.model.Projeto;
import br.com.ag.repository.ProjetoRepository;
import br.com.ag.util.Status;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;

	@Autowired
	private ClienteService clienteService;

	public Projeto salvar(Projeto projeto) {
		projeto.setCliente(findByCliendId(projeto.getCliente().getId()));
		return projetoRepository.save(projeto);
	}

	public Projeto buscarPorId(int id) {
		return projetoRepository.findById(id).orElse(null);
	}

	public List<Projeto> listarTodos() {
		return projetoRepository.findAll();
	}

	public List<Projeto> listarPorClienteId(int clienteId) {
		return projetoRepository.findByClienteId(clienteId);
	}

	private Cliente findByCliendId(Integer idCliente) {
		return clienteService.buscarPorId(idCliente);

	}

	public List<Projeto> listarPorStatus(String status) {
		return projetoRepository.findByStatus(Status.valueOf(status.toUpperCase()));
	}
}
