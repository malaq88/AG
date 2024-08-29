package br.com.ag.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StatusTest {

	@Test
	public void testGetDescription() {
		assertEquals("Aberto", Status.ABERTO.getDescription());
		assertEquals("Fechado", Status.FECHADO.getDescription());
	}

	@Test
	public void testForValue() {
		assertEquals(Status.ABERTO, Status.forValue("Aberto"));
		assertEquals(Status.FECHADO, Status.forValue("Fechado"));
		assertThrows(IllegalArgumentException.class, () -> Status.forValue("Inexistente"));
	}

	@Test
	public void testToString() {
		assertEquals("ABERTO: Aberto", Status.ABERTO.toString());
		assertEquals("FECHADO: Fechado", Status.FECHADO.toString());
	}

	@Test
	public void testJsonValue() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(Status.ABERTO);
		assertEquals("\"Aberto\"", json);
	}

	@Test
	public void testJsonCreator() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Status status = mapper.readValue("\"Aberto\"", Status.class);
		assertEquals(Status.ABERTO, status);

		assertThrows(JsonMappingException.class, () -> mapper.readValue("\"Inexistente\"", Status.class));
	}
}
