package br.unitins.topicos2.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.topicos2.model.Cidade;

public class CidadeRepository extends Repository<Cidade> {
	
	public CidadeRepository(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cidade> getCidades(String nome) {
		Query query = getEntityManager().
				createQuery("Select c From Cidade c WHERE LOWER(c.nome) LIKE LOWER(:nome) Order by c.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<Cidade> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Cidade>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cidade> getCidades(String nome, int limite) {
		Query query = getEntityManager().
				createQuery("Select c From Cidade c WHERE LOWER(c.nome) LIKE LOWER(:nome) Order by c.nome");
		query.setParameter("nome", "%" + nome + "%");
		query.setMaxResults(limite);
		List<Cidade> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Cidade>();
		return lista;
	}
}
