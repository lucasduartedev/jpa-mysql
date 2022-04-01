package br.com.pratica.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.pratica.jpa.models.PessoaFisica;
import br.com.pratica.jpa.models.PessoaJurica;

public class PessoaJuridicaDAO extends DAO<PessoaJurica> {

	public PessoaJuridicaDAO() {
		super();
	}

	public PessoaJuridicaDAO(Class<PessoaJurica> classe) {
		super(classe);
	}
	
	// Métodos especiais
	private TypedQuery<PessoaJurica> jpqlDefault(String jpql) {
		TypedQuery<PessoaJurica> query = this.getEntityManager()
				.createQuery(jpql, PessoaJurica.class);
		return query;
	}
	
	public List<PessoaJurica> obterTodosRegistros() {
		TypedQuery<PessoaJurica> query = jpqlDefault("SELECT p FROM PessoaJurica p");
		return query.getResultList();
	}

}
