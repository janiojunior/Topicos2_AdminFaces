package br.unitins.topicos2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos2.model.PessoaFisica;
import br.unitins.topicos2.model.Telefone;
import br.unitins.topicos2.repository.PessoaRepository;

@Named
@ViewScoped
public class PessoaFisicaController extends Controller<PessoaFisica>  {

	private static final long serialVersionUID = -4270221378549569000L;

	private String pesquisa;
	
	private Telefone telefone;
	
	private List<PessoaFisica> listaPessoa = null;
	
	
	public void adicionarTelefone() {
		// verificar se estah nulo (new ArrayList<telefone>()
		//getEntity().getListaTelefone()
		// 
		getEntity().getListaTelefone().add(getTelefone());
	}
	
	public void limpar() {
		setEntity(null);
		listaPessoa = null;
	}
	
	public void pesquisar() {
		PessoaRepository repository = new PessoaRepository(getEntityManager());
		listaPessoa = repository.getPessoas(pesquisa);
	}
	
	public List<PessoaFisica> getListaPessoa() {
		if (listaPessoa == null)
			listaPessoa = new ArrayList<PessoaFisica>();
		return listaPessoa;
	}

	@Override
	public PessoaFisica getEntity() {
		if (entity == null)
			entity = new PessoaFisica();
		return entity;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}




}
