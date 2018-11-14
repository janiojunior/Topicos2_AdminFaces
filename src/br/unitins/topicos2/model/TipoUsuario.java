package br.unitins.topicos2.model;

public enum TipoUsuario {
	
	ADMINSTRADOR(0, "Adminstrador"),
	USUARIO_COMUM(1, "Usuário Comum");
	
	private int id;
	private String label;
	
	private TipoUsuario(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}

}
