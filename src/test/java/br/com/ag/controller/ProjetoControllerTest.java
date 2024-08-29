package br.com.ag.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import br.com.ag.model.Cliente;
import br.com.ag.model.Projeto;
import br.com.ag.service.ProjetoService;
import br.com.ag.util.Status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ProjetoController.class)
public class ProjetoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProjetoService projetoService;

	private Projeto projeto = new Projeto(1, "", new Cliente(), null, Status.ABERTO);
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testBuscarProjetoPorId() throws Exception {
		when(projetoService.buscarPorId(1)).thenReturn(projeto);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/projeto/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		Projeto projetoEncontrado = new ObjectMapper().readValue(content, Projeto.class);

		assertNotNull(projetoEncontrado);
		assertEquals(projeto.getId(), projetoEncontrado.getId());
		assertEquals(projeto.getNome(), projetoEncontrado.getNome());
	}

	@Test
	public void testListarProjetosPorCliente() throws Exception {
		int clienteId = 1001;
		List<Projeto> projetos = Collections.singletonList(projeto);
		when(projetoService.listarPorClienteId(clienteId)).thenReturn(projetos);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/projeto/cliente/" + clienteId)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		List<Projeto> projetosEncontrados = Arrays.asList(new ObjectMapper().readValue(content, Projeto[].class));

		assertNotNull(projetosEncontrados);
		assertEquals(1, projetosEncontrados.size());

		Projeto projetoListado = projetosEncontrados.get(0);
		assertEquals(projeto.getId(), projetoListado.getId());
		assertEquals(projeto.getNome(), projetoListado.getNome());
	}

	@Test
	public void testListarProjetoPorStatus() throws Exception {
		Mockito.when(projetoService.listarPorStatus("aberto")).thenReturn(List.of(projeto));

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/projeto/status").param("status", "aberto")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, Projeto.class);
		List<Projeto> projetos = mapper.readValue(content, type);

		assertNotNull(projetos);
		assertEquals(1, projetos.size());

		Projeto projetoListado = projetos.get(0);
		assertEquals(projeto.getId(), projetoListado.getId());
		assertEquals(projeto.getStatus(), projetoListado.getStatus());
	}

	@Test
	public void testAdicionarProjeto() throws Exception {
		Mockito.when(projetoService.salvar(Mockito.any(Projeto.class))).thenReturn(projeto);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/projeto").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(projeto)))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		Projeto projetoSalvo = objectMapper.readValue(content, Projeto.class);
		assertNotNull(projetoSalvo);
		assertEquals(projeto.getId(), projetoSalvo.getId());
	}

}
