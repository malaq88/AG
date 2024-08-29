package br.com.ag.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {

	private Cliente cliente;
	private Projeto projeto;

	@BeforeEach
	void setUp() {
		projeto = new Projeto();
		projeto.setId(1);
		projeto.setNome("Projeto Teste");

		List<Projeto> projetos = new ArrayList<>();
		projetos.add(projeto);

		cliente = new Cliente();
		cliente.setId(1);
		cliente.setNome("Cliente Teste");
		cliente.setProjetos(projetos);

		projeto.setCliente(cliente);
	}

	@Test
	void testCliente() {
		assertNotNull(cliente);
		assertEquals(1, cliente.getId());
		assertEquals("Cliente Teste", cliente.getNome());
		assertNotNull(cliente.getProjetos());
		assertEquals(1, cliente.getProjetos().size());
		assertEquals(projeto, cliente.getProjetos().get(0));
	}

	@Test
	void testClienteGettersAndSetters() {
		Cliente cliente = new Cliente();
		cliente.setId(2);
		cliente.setNome("Novo Cliente");
		List<Projeto> novosProjetos = new ArrayList<>();
		cliente.setProjetos(novosProjetos);

		assertEquals(2, cliente.getId());
		assertEquals("Novo Cliente", cliente.getNome());
		assertEquals(novosProjetos, cliente.getProjetos());
	}

	@Test
	void testClienteConstructor() {
		List<Projeto> projetos = new ArrayList<>();
		Cliente cliente = new Cliente(3, "Cliente Construtor", projetos);

		assertEquals(3, cliente.getId());
		assertEquals("Cliente Construtor", cliente.getNome());
		assertEquals(projetos, cliente.getProjetos());
	}
}
