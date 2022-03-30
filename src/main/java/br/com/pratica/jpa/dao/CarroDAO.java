package br.com.pratica.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.pratica.jpa.models.Carro;

public class CarroDAO extends DAO<Carro> {

	// Contrutores
	public CarroDAO() {
		super();
	}

	public CarroDAO(Class<Carro> classe) {
		super(classe);
	}
	
	// Métodos especiais
	private TypedQuery<Carro> jpqlDefault(String jpql) {
		TypedQuery<Carro> query = this.getEntityManager()
				.createQuery(jpql, Carro.class);
		return query;
	}
	
	public List<Carro> obterTodosCarros() {
		TypedQuery<Carro> query = jpqlDefault("SELECT c FROM Carro c");
		return query.getResultList();
	}
	
}
