package br.unitins.topicos2.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = -3763771903748482697L;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	private String cpf;
	private String rg;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="pessoaFisica")
	private List<Telefone> listaTelefone;
	

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public List<Telefone> getListaTelefone() {
		return listaTelefone;
	}

	public void setListaTelefone(List<Telefone> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}
	
	
}
