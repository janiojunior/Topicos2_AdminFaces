package br.unitins.topicos2.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.topicos2.model.PessoaFisica;

public class PessoaRepository extends Repository<PessoaFisica> {
	
	public PessoaRepository(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaFisica> getPessoas(String nome) {
		Query query = getEntityManager().
				createQuery("Select p From Pessoa p WHERE LOWER(p.nome) LIKE LOWER(:nome) Order by p.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<PessoaFisica> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<PessoaFisica>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaFisica> getPessoas() {
		List<PessoaFisica> lista = getEntityManager().
				createQuery("Select p From Pessoa p Order by p.id desc").getResultList();
			if (lista == null)
				lista = new ArrayList<PessoaFisica>();
		return lista;
	}
}
