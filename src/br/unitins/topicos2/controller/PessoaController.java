package br.unitins.topicos2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unitins.topicos2.factory.JPAFactory;
import br.unitins.topicos2.model.Pessoa;
import br.unitins.topicos2.repository.PessoaRepository;

@Named
@ViewScoped
public class PessoaController extends Controller  {

	private static final long serialVersionUID = -4270221378549569000L;

	private List<Pessoa> listaPessoa = null;
	
	
	public void limpar() {
		setEntity(null);
		listaPessoa = null;
	}
	
	public List<Pessoa> getListaPessoa() {
		PessoaRepository repository = new PessoaRepository(getEntityManager());
		if (listaPessoa == null)
			listaPessoa = repository.getPessoas();
		
		return listaPessoa;
	}

	public Pessoa getEntity() {
		if (entity == null)
			entity = new Pessoa();
		return entity;
	}


}
