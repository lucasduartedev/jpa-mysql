package br.com.pratica.jpa.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlunoDadosPessoal {
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "rg", nullable = false)
	private String rg;
	
	// Contrutores
	public AlunoDadosPessoal() {
	}

	public AlunoDadosPessoal(String cpf, String rg) {
		super();
		this.cpf = cpf;
		this.rg = rg;
	}

	// Getters & Setters
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
	
}
