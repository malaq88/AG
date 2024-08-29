package br.com.ag.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import br.com.ag.model.Cliente;
import br.com.ag.service.ClienteService;

@WebMvcTest(ClienteController.class)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class ClienteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private ClienteService clienteService;

	private Cliente cliente;

	@BeforeEach
	void setUp() {
		cliente = new Cliente();
		cliente.setId(1);
	}

	@Test
	public void testAdicionarCliente() throws Exception {
		Mockito.when(clienteService.salvar(Mockito.any(Cliente.class))).thenReturn(cliente);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/cliente").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(cliente)))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		Cliente clienteSalva = objectMapper.readValue(content, Cliente.class);
		assertNotNull(clienteSalva);
		assertEquals(cliente.getId(), clienteSalva.getId());
	}

	@Test
	public void testBuscarClientePorId() throws Exception {
		Mockito.when(clienteService.buscarPorId(1)).thenReturn(cliente);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/cliente/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		Cliente clienteRetornada = objectMapper.readValue(content, Cliente.class);
		assertNotNull(clienteRetornada);
		assertEquals(cliente.getId(), clienteRetornada.getId());
	}

	@Test
	public void testListarTodas() throws Exception {
		Mockito.when(clienteService.listarTodos()).thenReturn(List.of(cliente));

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/cliente").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, Cliente.class);
		List<Cliente> clientes = mapper.readValue(content, type);

		assertNotNull(clientes);
		assertEquals(1, clientes.size());

		Cliente clienteListada = clientes.get(0);
		assertEquals(cliente.getId(), clienteListada.getId());
	}

}