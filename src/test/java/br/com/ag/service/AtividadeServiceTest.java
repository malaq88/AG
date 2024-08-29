package br.com.ag.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.ag.model.Atividade;
import br.com.ag.model.Projeto;
import br.com.ag.repository.AtividadeRepository;
import br.com.ag.util.Status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest
public class AtividadeServiceTest {

	@Autowired
	private AtividadeService atividadeService;

	@MockBean
	private AtividadeRepository atividadeRepository;

	private Projeto projeto = new Projeto(1, "Projeto 1", null, null, Status.ABERTO);
	private Atividade atividade = new Atividade(1, "Atividade 1", projeto);

	@Test
	public void testSalvarAtividade() {

		when(atividadeRepository.save(any())).thenReturn(atividade);
		Atividade savedAtividade = atividadeService.salvar(atividade);

		assertNotNull(savedAtividade);
		assertNotNull(savedAtividade.getId());
	}

	@Test
	public void testBuscarPorId() {
		when(atividadeRepository.findById(anyInt())).thenReturn(java.util.Optional.of(atividade));
		Atividade foundAtividade = atividadeService.buscarPorId(1);
		assertNotNull(foundAtividade);
		assertEquals(atividade.getDescricao(), foundAtividade.getDescricao());
	}

	@Test
	public void testListarTodos() {
		List<Atividade> atividades = Arrays.asList(atividade);
		when(atividadeRepository.findAll()).thenReturn(atividades);
		List<Atividade> foundAtividades = atividadeService.listarTodos();
		assertNotNull(foundAtividades);
		assertEquals(1, foundAtividades.size());
	}
}
