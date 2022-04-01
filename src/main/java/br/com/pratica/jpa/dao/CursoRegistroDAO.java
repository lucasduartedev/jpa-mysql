package br.com.pratica.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.pratica.jpa.models.CursoRegistro;

public class CursoRegistroDAO extends DAO<CursoRegistro> {

	public CursoRegistroDAO() {
		super();
	}

	public CursoRegistroDAO(Class<CursoRegistro> classe) {
		super(classe);
	}

	// Métodos especiais
	private TypedQuery<CursoRegistro> jpqlDefault(String jpql) {
		TypedQuery<CursoRegistro> query = this.getEntityManager()
				.createQuery(jpql, CursoRegistro.class);
		return query;
	}
	
	public List<CursoRegistro> obterTodosRegistros() {
		TypedQuery<CursoRegistro> query = jpqlDefault("SELECT c FROM CursoRegistro c");
		return query.getResultList();
	}
	
}
