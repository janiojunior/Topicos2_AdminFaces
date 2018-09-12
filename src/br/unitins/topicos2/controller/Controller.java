package br.unitins.topicos2.controller;

import java.io.Serializable;

import javax.persistence.EntityManager;

import br.unitins.topicos2.factory.JPAFactory;
import br.unitins.topicos2.model.DefaultEntity;
import br.unitins.topicos2.model.Pessoa;
import br.unitins.topicos2.repository.PessoaRepository;
import br.unitins.topicos2.repository.Repository;

public abstract class Controller<T extends DefaultEntity<T>> implements Serializable {
	
	private static final long serialVersionUID = -4859697154833778954L;
	
	private EntityManager em = null;
	
	protected T entity = null;
	
	public abstract T getEntity();
	
	public void setEntity(T entity) {
		this.entity = entity;
	}
	
	protected EntityManager getEntityManager() {
		if (em == null)
			em = JPAFactory.getEntityManager();
		return em;
	}
	
	public abstract void limpar();
	
	public T incluir() {
		Repository<T> repository = new Repository<T>(getEntityManager());
		getEntityManager().getTransaction().begin();
		
		// incluir 
		T result = repository.save(getEntity());
		//getEntityManager().persist(getPessoa());
		
		getEntityManager().getTransaction().commit();
		limpar();
		System.out.println("Incluir");
		return result;
	}
	
	public T alterar() {
		Repository<T> repository = new Repository<T>(getEntityManager());
		getEntityManager().getTransaction().begin();
		
		// alterar 
		T result = repository.save(getEntity());
		
		getEntityManager().getTransaction().commit();
		limpar();
		System.out.println("Alterar");
		return result;
	}
	
	public void remover() {
		Repository<T> repository = new Repository<T>(getEntityManager());
		getEntityManager().getTransaction().begin();
		
		// remover 
		repository.remove(getEntity());
		
		getEntityManager().getTransaction().commit();
		limpar();
		System.out.println("Remover");
	}
}
