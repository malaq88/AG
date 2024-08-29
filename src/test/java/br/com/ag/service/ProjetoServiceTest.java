package br.com.ag.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.ag.model.Cliente;
import br.com.ag.model.Projeto;
import br.com.ag.repository.ProjetoRepository;
import br.com.ag.util.Status;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ProjetoServiceTest {

	@Mock
	private ProjetoRepository projetoRepository;

	@Mock
	private ClienteService clienteService;

	@InjectMocks
	private ProjetoService projetoService;
	private Projeto projeto;

	@BeforeEach
	void setUp() {
		projeto = new Projeto();
		projeto.setId(1);
		projeto.setStatus(Status.ABERTO);
	}

	@Test
	public void testSalvarProjeto() {
		Cliente cliente = new Cliente(1, "Cliente A", null);
		Projeto projeto = new Projeto(1, "Projeto X", cliente, null, Status.ABERTO);

		when(clienteService.buscarPorId(cliente.getId())).thenReturn(cliente);

		when(projetoRepository.save(projeto)).thenReturn(projeto);

		Projeto savedProjeto = projetoService.salvar(projeto);

		assertEquals(projeto.getId(), savedProjeto.getId());
		assertEquals(projeto.getNome(), savedProjeto.getNome());
		assertEquals(projeto.getCliente().getId(), savedProjeto.getCliente().getId());

		verify(clienteService, times(1)).buscarPorId(cliente.getId());

		verify(projetoRepository, times(1)).save(projeto);
	}

	@Test
	public void testBuscarPorId() {
		Projeto projeto = new Projeto(1, "Projeto X", new Cliente(1, "Cliente A", null), null, Status.ABERTO);

		when(projetoRepository.findById(projeto.getId())).thenReturn(Optional.of(projeto));

		Projeto retrievedProjeto = projetoService.buscarPorId(projeto.getId());

		assertEquals(projeto.getId(), retrievedProjeto.getId());
		assertEquals(projeto.getNome(), retrievedProjeto.getNome());

		verify(projetoRepository, times(1)).findById(projeto.getId());
	}

	@Test
	public void testListarTodos() {
		List<Projeto> projetos = Arrays.asList(
				new Projeto(1, "Projeto X", new Cliente(1, "Cliente A", null), null, Status.ABERTO),
				new Projeto(2, "Projeto Y", new Cliente(2, "Cliente B", null), null, Status.ABERTO));

		when(projetoRepository.findAll()).thenReturn(projetos);

		List<Projeto> projetosRetornados = projetoService.listarTodos();

		assertFalse(projetosRetornados.isEmpty());
		assertEquals(projetos.size(), projetosRetornados.size());

		verify(projetoRepository, times(1)).findAll();
	}

	@Test
	public void testListarPorClienteId() {
		int clienteId = 1;
		Cliente cliente = new Cliente(clienteId, "Cliente A", null);
		List<Projeto> projetos = Arrays.asList(new Projeto(1, "Projeto X", cliente, null, Status.ABERTO),
				new Projeto(2, "Projeto Y", cliente, null, Status.ABERTO));

		when(projetoRepository.findByClienteId(clienteId)).thenReturn(projetos);

		List<Projeto> projetosCliente = projetoService.listarPorClienteId(clienteId);

		assertFalse(projetosCliente.isEmpty());
		assertEquals(projetos.size(), projetosCliente.size());

		verify(projetoRepository, times(1)).findByClienteId(clienteId);
	}

	@Test
	public void testListarPorStatus() {

		Mockito.when(projetoRepository.findByStatus(Status.ABERTO)).thenReturn(List.of(projeto));

		List<Projeto> projetos = projetoService.listarPorStatus("aberto");

		assertNotNull(projetos);
		assertEquals(1, projetos.size());
		assertEquals(projeto.getId(), projetos.get(0).getId());
		assertEquals(projeto.getStatus(), projetos.get(0).getStatus());
	}
}
