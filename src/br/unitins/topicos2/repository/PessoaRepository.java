package br.unitins.topicos2.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.unitins.topicos2.model.Pessoa;

public class PessoaRepository extends Repository<Pessoa> {
	
	
	public PessoaRepository(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> getPessoas() {
		List<Pessoa> lista = getEntityManager().
				createQuery("Select p From Pessoa p Order by p.id desc").getResultList();
			if (lista == null)
				lista = new ArrayList<Pessoa>();
		return lista;
	}
}
