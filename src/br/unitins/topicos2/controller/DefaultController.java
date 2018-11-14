package br.unitins.topicos2.controller;

import java.io.Serializable;

import br.unitins.topicos2.application.Session;
import br.unitins.topicos2.model.Usuario;

public class DefaultController implements Serializable {

	private static final long serialVersionUID = 1007297527954376818L;
	private static final String userKey = "usuarioLogado";
	
	public Usuario getUsuarioLogado() {
		return (Usuario) Session.getInstance().getAttribute(userKey);
	}

	public void setUsuarioLogado(Usuario usuario) {
		Session.getInstance().setAttribute(userKey, usuario);
	}
	
	public void encerrarSessao() {
		Session.getInstance().invalidateSession();
	}
	
}
