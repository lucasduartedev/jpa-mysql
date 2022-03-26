package br.com.pratica.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {
	
	private static EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private Class<E> classe;
	
	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("banco_mysql");
		} catch (Exception e) {
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public DAO<E> abrirTransacao() {
		entityManager.getTransaction().begin();
		return this;
	}

	public DAO<E> fecharT() {
		entityManager.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade) {
		entityManager.persist(entidade);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade) {
		return this.abrirTransacao().incluir(entidade).fecharT();
	}
	
	public List<E> obterTodos() {
		return this.obterTodos(10, 0);
	}
	
	public List<E> obterTodos(int quantidade, int deslocamento) {
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula");
		}
		
		String jpql = "SELECT e FROM " + classe.getName() + " e";
		
		TypedQuery<E> query = entityManager.createQuery(jpql, classe);
		query.setMaxResults(quantidade);
		query.setFirstResult(deslocamento);
		
		return query.getResultList();
		
	}

}
