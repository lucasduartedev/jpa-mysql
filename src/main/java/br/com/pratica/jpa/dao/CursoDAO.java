package br.com.pratica.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.pratica.jpa.models.Curso;

public class CursoDAO extends DAO<Curso> {

	public CursoDAO() {
		super();
	}

	public CursoDAO(Class<Curso> classe) {
		super(classe);
	}
	
	// Métodos especiais
	private TypedQuery<Curso> jpqlDefault(String jpql) {
		TypedQuery<Curso> query = this.getEntityManager()
				.createQuery(jpql, Curso.class);
		return query;
	}
	
	public List<Curso> obterTodosCursos() {
		TypedQuery<Curso> query = jpqlDefault("SELECT c FROM Curso c");
		return query.getResultList();
	}
	
}
