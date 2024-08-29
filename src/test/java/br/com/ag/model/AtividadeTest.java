package br.com.ag.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AtividadeTest {

	private Atividade atividade;
	private Projeto projeto;

	@BeforeEach
	void setUp() {
		projeto = new Projeto();
		projeto.setId(1);
		projeto.setNome("Projeto Teste");

		atividade = new Atividade();
		atividade.setId(1);
		atividade.setDescricao("Atividade Teste");
		atividade.setProjeto(projeto);
	}

	@Test
	void testAtividade() {
		assertNotNull(atividade);
		assertEquals(1, atividade.getId());
		assertEquals("Atividade Teste", atividade.getDescricao());
		assertNotNull(atividade.getProjeto());
		assertEquals(projeto, atividade.getProjeto());
	}
}
