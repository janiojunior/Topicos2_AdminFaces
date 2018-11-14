package br.unitins.topicos2.controller;

import javax.persistence.EntityManager;

import br.unitins.topicos2.application.Util;
import br.unitins.topicos2.factory.JPAFactory;
import br.unitins.topicos2.model.DefaultEntity;
import br.unitins.topicos2.repository.Repository;

public abstract class Controller<T extends DefaultEntity<? super T>> extends DefaultController {
	
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
		
		getEntityManager().getTransaction().commit();
		limpar();
		Util.addInfoMessage("Inclusão realizada com sucesso!");
		return result;
	}
	
	public T alterar() {
		Repository<T> repository = new Repository<T>(getEntityManager());
		getEntityManager().getTransaction().begin();
		
		// alterar 
		T result = repository.save(getEntity());
		
		getEntityManager().getTransaction().commit();
		limpar();
		Util.addInfoMessage("Alteração realizada com sucesso!");
		return result;
	}
	
	public void remover() {
		Repository<T> repository = new Repository<T>(getEntityManager());
		getEntityManager().getTransaction().begin();
		
		// remover 
		repository.save(getEntity());
		repository.remove(getEntity());
		
		getEntityManager().getTransaction().commit();
		limpar();
		Util.addInfoMessage("Remoção realizada com sucesso!");
	}
}
