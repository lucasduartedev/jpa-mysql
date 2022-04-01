package br.com.pratica.jpa.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas_juridica")
public class PessoaJurica extends Pessoa {
	
	private String cnpj;
	
	// Contrutores
	public PessoaJurica() {
	}

	public PessoaJurica(String nome, String cnpj) {
		super(nome);
		this.cnpj = cnpj;
	}

	// Getters & Setters
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
