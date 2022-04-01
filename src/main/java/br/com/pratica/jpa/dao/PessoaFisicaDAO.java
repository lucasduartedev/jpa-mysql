package br.com.pratica.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.pratica.jpa.models.PessoaFisica;

public class PessoaFisicaDAO extends DAO<PessoaFisica> {

	public PessoaFisicaDAO() {
		super();
	}

	public PessoaFisicaDAO(Class<PessoaFisica> classe) {
		super(classe);
	}
	
	// Métodos especiais
	private TypedQuery<PessoaFisica> jpqlDefault(String jpql) {
		TypedQuery<PessoaFisica> query = this.getEntityManager()
				.createQuery(jpql, PessoaFisica.class);
		return query;
	}
	
	public List<PessoaFisica> obterTodosRegistros() {
		TypedQuery<PessoaFisica> query = jpqlDefault("SELECT p FROM PessoaFisica p");
		return query.getResultList();
	}

}
