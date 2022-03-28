package br.com.pratica.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.pratica.jpa.models.Endereco;

public class EnderecoDAO extends DAO<Endereco> {

//	Construtores
	public EnderecoDAO() {
		super();
	}

	public EnderecoDAO(Class<Endereco> classe) {
		super(classe);
	}
	
//	Métodos especiais
	private TypedQuery<Endereco> jpqlDefault(String jpql) {
		TypedQuery<Endereco> query = this.getEntityManager()
				.createQuery(jpql, Endereco.class);
		return query;
	}
	
	public List<Endereco> obterTodosEnderecos() {
		TypedQuery<Endereco> query = jpqlDefault("SELECT e FROM Endereco e");
		return query.getResultList();
	}

}
