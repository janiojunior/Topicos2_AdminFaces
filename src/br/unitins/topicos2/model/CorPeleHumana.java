package br.unitins.topicos2.model;

public enum CorPeleHumana {
	BRANCA(0, "Branca"),
	PRETA(1, "Preta"),
	AMARELA(2, "Amarela"),
	PARDA(3, "Parda");
	
	private int id;
	private String label;
	
	private CorPeleHumana(int id, String label) {
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
