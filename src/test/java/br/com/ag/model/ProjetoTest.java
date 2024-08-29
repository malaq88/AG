package br.com.ag.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.ag.util.Status;

public class ProjetoTest {

	private Projeto projeto;
	private Cliente cliente;
	private Atividade atividade;

	@BeforeEach
	void setUp() {
		cliente = new Cliente();
		cliente.setId(1);
		cliente.setNome("Cliente Teste");

		atividade = new Atividade();
		atividade.setId(1);
		atividade.setDescricao("Atividade Teste");

		List<Atividade> atividades = new ArrayList<>();
		atividades.add(atividade);

		projeto = new Projeto();
		projeto.setId(1);
		projeto.setNome("Projeto Teste");
		projeto.setCliente(cliente);
		projeto.setAtividades(atividades);
		projeto.setStatus(Status.ABERTO);

		atividade.setProjeto(projeto);
	}

	@Test
	void testProjeto() {
		assertNotNull(projeto);
		assertEquals(1, projeto.getId());
		assertEquals("Projeto Teste", projeto.getNome());
		assertNotNull(projeto.getCliente());
		assertEquals(cliente, projeto.getCliente());
		assertNotNull(projeto.getAtividades());
		assertEquals(1, projeto.getAtividades().size());
		assertEquals(atividade, projeto.getAtividades().get(0));
		assertEquals(Status.ABERTO, projeto.getStatus());
	}
}
