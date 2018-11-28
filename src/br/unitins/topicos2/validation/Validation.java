package br.unitins.topicos2.validation;

import br.unitins.topicos2.application.ValidationException;

public interface Validation<T> {
	public void validate(T t) throws ValidationException;
}