package br.unitins.topicos2.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Telefone extends DefaultEntity<Telefone>{
	
	private static final long serialVersionUID = 8193801112583377332L;
	
	private String codigoArea;
	private String numero;
	
	@ManyToOne
	@JoinColumn(name="idPessoaFisca")
	private PessoaFisica pessoaFisica;
	
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public PessoaFisica getPessoaFisida() {
		return pessoaFisica;
	}
	public void setPessoaFisida(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

}
