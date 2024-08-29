package br.com.ag.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.ag.model.Cliente;
import br.com.ag.repository.ClienteRepository;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ClienteServiceTest {

	@Mock
	private ClienteRepository clienteRepository;

	@InjectMocks
	private ClienteService clienteService;

	Cliente cliente = new Cliente(new Random().nextInt(), "João", null);

	@Test
	public void testSalvarCliente() {

		when(clienteRepository.save(cliente)).thenReturn(cliente);

		Cliente savedCliente = clienteService.salvar(cliente);

		assertEquals(cliente.getId(), savedCliente.getId());

		verify(clienteRepository, times(1)).save(cliente);
	}

	@Test
	public void testBuscarPorId() {

		when(clienteRepository.findById(cliente.getId())).thenReturn(Optional.of(cliente));

		Cliente retrievedCliente = clienteService.buscarPorId(cliente.getId());

		assertEquals(cliente.getId(), retrievedCliente.getId());

		verify(clienteRepository, times(1)).findById(cliente.getId());
	}

	@Test
	public void testListarTodos() {
		List<Cliente> clientes = Arrays.asList(cliente, cliente);

		when(clienteRepository.findAll()).thenReturn(clientes);

		List<Cliente> clientesRetornados = clienteService.listarTodos();

		assertFalse(clientesRetornados.isEmpty());
		assertEquals(clientes.size(), clientesRetornados.size());

		verify(clienteRepository, times(1)).findAll();
	}
}
