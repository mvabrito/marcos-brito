package br.com.mvabrito.validadorDTO.annotation;

import java.util.function.Predicate;

public abstract class Regras {

	public <T> Predicate<T> testeNull() {
		return t -> t != null;
	}

}
