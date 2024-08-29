package br.com.ag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ag.model.Projeto;
import br.com.ag.service.ProjetoService;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

	private final ProjetoService projetoService;

	@Autowired
	public ProjetoController(ProjetoService projetoService) {
		this.projetoService = projetoService;
	}

	@PostMapping
	public Projeto createProjeto(@RequestBody Projeto projeto) {
		return projetoService.salvar(projeto);
	}

	@GetMapping("/{id}")
	public Projeto getProjetoById(@PathVariable int id) {
		return projetoService.buscarPorId(id);
	}

	@GetMapping("/cliente/{clienteId}")
	public List<Projeto> getProjetosByClienteId(@PathVariable int clienteId) {
		return projetoService.listarPorClienteId(clienteId);
	}

	@GetMapping("/status")
	public List<Projeto> getProjetosByStatus(@RequestParam String status) {
		return projetoService.listarPorStatus(status);
	}
}

