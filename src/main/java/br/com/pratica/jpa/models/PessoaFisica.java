package br.com.pratica.jpa.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas_fisica")
public class PessoaFisica extends Pessoa {
	
	private String cpf;

	// Contrutores
	public PessoaFisica() {
	}

	public PessoaFisica(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
	}

	// Getters & Setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
