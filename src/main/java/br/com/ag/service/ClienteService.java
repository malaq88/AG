package br.com.ag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ag.model.Cliente;
import br.com.ag.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente buscarPorId(int id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}
}
