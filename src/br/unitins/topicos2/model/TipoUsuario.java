package br.unitins.topicos2.model;

import java.util.Arrays;
import java.util.List;

public enum TipoUsuario {
	
	ADMINSTRADOR(0, "Adminstrador", 
			Arrays.asList("cadastropessoa4.xhtml", "cadastrocidade.xhtml", "listagemcidade.xhtml", "listagemusuario.xhtml", "cadastrousuario.xhtml")),
	USUARIO_COMUM(1, "Usuário Comum", Arrays.asList("cadastropessoa4.xhtml", "listagemcidade.xhtml"));
	
	private int id;
	private String label;
	private List<String> pages;
	
	private TipoUsuario(int id, String label, List<String> pages) {
		this.id = id;
		this.label = label;
		this.pages = pages;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}

	public List<String> getPages() {
		return pages;
	}
	
}
