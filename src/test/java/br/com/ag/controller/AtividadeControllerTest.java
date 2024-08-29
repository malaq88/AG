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

import br.com.ag.model.Atividade;
import br.com.ag.service.AtividadeService;

@WebMvcTest(AtividadeController.class)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class AtividadeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private AtividadeService atividadeService;

	private Atividade atividade;

	@BeforeEach
	void setUp() {
		atividade = new Atividade();
		atividade.setId(1);
		atividade.setDescricao("Atividade de exemplo");
	}

	@Test
	public void testAdicionarAtividade() throws Exception {
		Mockito.when(atividadeService.salvar(Mockito.any(Atividade.class))).thenReturn(atividade);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/atividade").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(atividade)))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		Atividade atividadeSalva = objectMapper.readValue(content, Atividade.class);
		assertNotNull(atividadeSalva);
		assertEquals(atividade.getId(), atividadeSalva.getId());
		assertEquals(atividade.getDescricao(), atividadeSalva.getDescricao());
	}

	@Test
	public void testBuscarAtividadePorId() throws Exception {
		Mockito.when(atividadeService.buscarPorId(1)).thenReturn(atividade);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/atividade/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		Atividade atividadeRetornada = objectMapper.readValue(content, Atividade.class);
		assertNotNull(atividadeRetornada);
		assertEquals(atividade.getId(), atividadeRetornada.getId());
		assertEquals(atividade.getDescricao(), atividadeRetornada.getDescricao());
	}

	@Test
	public void testListarTodas() throws Exception {
		Mockito.when(atividadeService.listarTodos()).thenReturn(List.of(atividade));

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/atividade").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, Atividade.class);
		List<Atividade> atividades = mapper.readValue(content, type);

		assertNotNull(atividades);
		assertEquals(1, atividades.size());

		Atividade atividadeListada = atividades.get(0);
		assertEquals(atividade.getId(), atividadeListada.getId());
		assertEquals(atividade.getDescricao(), atividadeListada.getDescricao());
	}

}
