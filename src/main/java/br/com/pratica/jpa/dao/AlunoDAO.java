package br.com.pratica.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.pratica.jpa.models.Aluno;

public class AlunoDAO extends DAO<Aluno> {

	public AlunoDAO() {
		super();
	}

	public AlunoDAO(Class<Aluno> classe) {
		super(classe);
	}
	
	// Métodos especiais
	private TypedQuery<Aluno> jpqlDefault(String jpql) {
		TypedQuery<Aluno> query = this.getEntityManager()
				.createQuery(jpql, Aluno.class);
		return query;
	}
	
	public List<Aluno> obterTodosAlunos() {
		TypedQuery<Aluno> query = jpqlDefault("SELECT c FROM Aluno c");
		return query.getResultList();
	}
	
}
