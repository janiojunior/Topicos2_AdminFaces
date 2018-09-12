package br.unitins.topicos2.controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos2.model.Pessoa;
import br.unitins.topicos2.repository.PessoaRepository;

@Named
@ViewScoped
public class PessoaController extends Controller<Pessoa>  {

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

	@Override
	public Pessoa getEntity() {
		if (entity == null)
			entity = new Pessoa();
		return entity;
	}






}
