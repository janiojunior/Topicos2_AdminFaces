package br.unitins.topicos2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Pessoa extends DefaultEntity<Pessoa> {

	private static final long serialVersionUID = -3763771903748482697L;

	@Transient
	private Date dataNascimento;
	
	private String nome;
	private String endereco;
	private String email;

	public Pessoa() {
		// default
	}

	public Pessoa(String nome, String endereco, String email) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
