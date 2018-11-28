package br.unitins.topicos2.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.topicos2.application.Util;
import br.unitins.topicos2.factory.JPAFactory;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.UsuarioRepository;
import br.unitins.topicos2.validation.Validation;

@Named
@RequestScoped
public class LoginController extends DefaultController {
	private static final long serialVersionUID = -2482810615603773001L;

	private Usuario usuario;
	
	public String entrar() {
		UsuarioRepository repository = 
				new UsuarioRepository(JPAFactory.getEntityManager());
		Usuario usuarioValidado = repository
				.getUsuario(getUsuario().getEmail(), getUsuario().getSenha());
		
		if (usuarioValidado == null) {
			Util.addErroMessage("Usuário ou Senha inválido.");
			return null;
		}
		// setando o usuario na sessao
		setUsuarioLogado(usuarioValidado);
		
		return "pages/cadastropessoa4.xhtml";
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
