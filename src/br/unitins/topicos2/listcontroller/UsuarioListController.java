package br.unitins.topicos2.listcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioListController extends ListController {
	
	private static final long serialVersionUID = 7632575195233463555L;
	
	private String nome;
	
	private List<Usuario> listaUsuario;

	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			listaUsuario = new ArrayList<Usuario>();
		}
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	public void pesquisar() {
		UsuarioRepository repository = new UsuarioRepository(getEntityManager());
		listaUsuario = repository.getUsuarios(nome);
	}
	
	public void selecionar(Usuario usuario) {
		PrimeFaces.current().dialog().closeDynamic(usuario);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
