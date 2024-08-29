package br.com.ag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ag.model.Atividade;
import br.com.ag.model.Projeto;
import br.com.ag.repository.AtividadeRepository;

@Service
public class AtividadeService {

	@Autowired
	private AtividadeRepository atividadeRepository;

	@Autowired
	private ProjetoService projetoService;

	public Atividade salvar(Atividade atividade) {

		atividade.setProjeto(findByProjetoId(atividade.getProjeto().getId()));
		return atividadeRepository.save(atividade);
	}

	public Atividade buscarPorId(int id) {
		return atividadeRepository.findById(id).orElse(null);
	}

	public List<Atividade> listarTodos() {
		return atividadeRepository.findAll();
	}

	private Projeto findByProjetoId(Integer projetoId) {
		return projetoService.buscarPorId(projetoId);
	}
}
