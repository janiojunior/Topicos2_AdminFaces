package br.unitins.topicos2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import br.unitins.topicos2.factory.JPAFactory;
import br.unitins.topicos2.model.Cidade;
import br.unitins.topicos2.model.CorPeleHumana;
import br.unitins.topicos2.model.PessoaFisica;
import br.unitins.topicos2.model.Sexo;
import br.unitins.topicos2.model.Telefone;
import br.unitins.topicos2.repository.CidadeRepository;
import br.unitins.topicos2.repository.PessoaRepository;

@Named
@ViewScoped
public class PessoaFisicaController extends Controller<PessoaFisica>  {

	private static final long serialVersionUID = -4270221378549569000L;

	private String pesquisa;
	
	private Telefone telefone;
	
	private List<PessoaFisica> listaPessoa = null;
	
	private List<Cidade> listaCidade = null;
	
	
	public void adicionarTelefone() {
		if (getEntity().getListaTelefone() == null)
			getEntity().setListaTelefone(new ArrayList<Telefone>());
		
		// relacionando o telefone com a pessoa
		getTelefone().setPessoa(getEntity());
		
		// adicionando o telefone na lista
		getEntity().getListaTelefone().add(getTelefone());
		
		//limpando o telefone depois da adicao
		setTelefone(null);
	}
	
	public void removerTelefone(Telefone telefone) {
		System.out.println(telefone.getNumero());
		getEntity().getListaTelefone().remove(telefone);
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
		if (entity == null) {
			entity = new PessoaFisica();
			entity.setCidadeNatal(new Cidade());
		}
		return entity;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Telefone getTelefone() {
		if (telefone == null) {
			telefone = new Telefone();
		}
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public void abrirListagemCidade() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false); // nao permite redimencionar
        options.put("draggable", false); // nao permite arrastar
        options.put("modal", true); // abrir como modal
        options.put("width", "80%");
        options.put("height", "500");
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        PrimeFaces.current().dialog().openDynamic("listagemcidade", options, null);
    }

	public void cidadeSelecionada(SelectEvent event) {
        Cidade cidade = (Cidade) event.getObject();
        getEntity().setCidadeNatal(cidade);
    }
	
	public Sexo[] getVetorSexo() {
		return Sexo.values();
	}
	
	public CorPeleHumana[] getVetorCorPeleHumana() {
		return CorPeleHumana.values();
	}
	
	public List<Cidade> getListaCidade() {
		if (listaCidade == null) {
			CidadeRepository repo = new CidadeRepository(JPAFactory.getEntityManager());
			listaCidade = repo.getCidades("");
		}
		return listaCidade;
	}
	
	public List<Cidade> getListaCidadeAutoComplete(String nome) {
		CidadeRepository repo = new CidadeRepository(JPAFactory.getEntityManager());
		listaCidade = repo.getCidades(nome, 2);
		return listaCidade;
	}

}
