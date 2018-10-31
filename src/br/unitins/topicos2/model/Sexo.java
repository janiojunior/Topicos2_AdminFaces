package br.unitins.topicos2.model;

public enum Sexo {
	
	MASCULINO(0, "Masculino"),
	FEMININO(1, "Feminino");
	
	private int id;
	private String label;
	
	private Sexo(int id, String label) {
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
