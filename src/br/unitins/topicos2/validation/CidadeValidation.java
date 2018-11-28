package br.unitins.topicos2.validation;

import br.unitins.topicos2.application.ValidationException;
import br.unitins.topicos2.model.Cidade;

public class CidadeValidation implements Validation<Cidade> {

	@Override
	public void validate(Cidade t) throws ValidationException {
		
		if (t.getNome() == null || t.getNome().trim().equals("")) {
			throw new ValidationException("O nome da cidade não pode ser vazio.");
		}
		
		if (t.getEstado() == null || t.getEstado().trim().equals("")) {
			throw new ValidationException("O nome do estado não pode ser vazio.");
		}
		
		if (t.getPais() == null || t.getPais().trim().equals("")) {
			throw new ValidationException("O pais não pode ser vazio.");
		}

	}

}
