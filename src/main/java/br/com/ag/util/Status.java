package br.com.ag.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
	ABERTO("Aberto"), FECHADO("Fechado");

	private final String description;

	Status(String description) {
		this.description = description;
	}

	@JsonValue
	public String getDescription() {
		return description;
	}

	@JsonCreator
	public static Status forValue(String value) {
		for (Status status : Status.values()) {
			if (status.getDescription().equals(value)) {
				return status;
			}
		}
		throw new IllegalArgumentException("status inválido: " + value);
	}

	@Override
	public String toString() {
		return this.name() + ": " + this.getDescription();
	}
}