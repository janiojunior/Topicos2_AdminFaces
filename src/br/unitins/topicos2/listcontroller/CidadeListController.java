package br.unitins.topicos2.listcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.unitins.topicos2.model.Cidade;
import br.unitins.topicos2.repository.CidadeRepository;

@Named
@ViewScoped
public class CidadeListController extends ListController {
	
	private static final long serialVersionUID = 7632575195233463555L;
	
	private String nome;
	
	private List<Cidade> listaCidade;

	public List<Cidade> getListaCidade() {
		if (listaCidade == null) {
			listaCidade = new ArrayList<Cidade>();
		}
		return listaCidade;
	}

	public void setListaCidade(List<Cidade> listaCidade) {
		this.listaCidade = listaCidade;
	}
	
	public void pesquisar() {
		CidadeRepository repository = new CidadeRepository(getEntityManager());
		listaCidade = repository.getCidades(nome);
	}
	
	public void selecionar(Cidade cidade) {
		PrimeFaces.current().dialog().closeDynamic(cidade);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
