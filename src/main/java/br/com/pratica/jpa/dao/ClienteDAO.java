package br.com.pratica.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.pratica.jpa.models.Cliente;

public class ClienteDAO extends DAO<Cliente> {

	// Contrutores
	public ClienteDAO() {
		super();
	}

	public ClienteDAO(Class<Cliente> classe) {
		super(classe);
	}

	// Métodos especiais
	private TypedQuery<Cliente> jpqlDefault(String jpql) {
		TypedQuery<Cliente> query = this.getEntityManager()
				.createQuery(jpql, Cliente.class);
		return query;
	}
	
	public List<Cliente> obterTodosClientes() {
		TypedQuery<Cliente> query = jpqlDefault("SELECT c FROM Cliente c");
		return query.getResultList();
	}
	
}
