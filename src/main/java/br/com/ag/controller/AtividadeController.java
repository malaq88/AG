package br.com.ag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ag.model.Atividade;
import br.com.ag.service.AtividadeService;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {

	private final AtividadeService atividadeService;

	@Autowired
	public AtividadeController(AtividadeService atividadeService) {
		this.atividadeService = atividadeService;
	}

	@PostMapping
	public Atividade adicionarAtividade(@RequestBody Atividade atividade) {
		return atividadeService.salvar(atividade);
	}

	@GetMapping("/{id}")
	public Atividade buscarAtividadePorId(@PathVariable int id) {
		return atividadeService.buscarPorId(id);
	}

	@GetMapping
	public List<Atividade> listarTodas() {
		return atividadeService.listarTodos();
	}
}
