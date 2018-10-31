package br.unitins.topicos2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = -3763771903748482697L;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	private String cpf;
	private String rg;
	private Sexo sexo;
	private CorPeleHumana corPeleHumana;

	@ManyToOne
	@JoinColumn(name = "idCidadeNatal")
	private Cidade cidadeNatal;

	@ManyToOne
	@JoinColumn(name = "idCidadeAtual")
	private Cidade cidadeAtual;

	@ManyToOne
	@JoinColumn(name = "idCidadeFutura")
	private Cidade cidadeFutura;

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

	public Cidade getCidadeNatal() {
		return cidadeNatal;
	}

	public void setCidadeNatal(Cidade cidadeNatal) {
		this.cidadeNatal = cidadeNatal;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public CorPeleHumana getCorPeleHumana() {
		return corPeleHumana;
	}

	public void setCorPeleHumana(CorPeleHumana corPeleHumana) {
		this.corPeleHumana = corPeleHumana;
	}

	public Cidade getCidadeAtual() {
		return cidadeAtual;
	}

	public void setCidadeAtual(Cidade cidadeAtual) {
		this.cidadeAtual = cidadeAtual;
	}

	public Cidade getCidadeFutura() {
		return cidadeFutura;
	}

	public void setCidadeFutura(Cidade cidadeFutura) {
		this.cidadeFutura = cidadeFutura;
	}

}
