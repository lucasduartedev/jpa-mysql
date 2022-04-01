package br.com.pratica.jpa.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlunoDadosPessoal implements Serializable {
	
	private static final long serialVersionUID = 1L;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
