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
			System.out.println("Error ao conectar ao banco de dados :(");
		}
	}
	
	// Contrutores
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	// Métodos especiais
	public DAO<E> abrirTransacao() {
		entityManager.getTransaction().begin();
		return this;
	}

	public DAO<E> comitarTransacao() {
		entityManager.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade) {
		entityManager.persist(entidade);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade) { // Incluir atomico
		return this.abrirTransacao().incluir(entidade).comitarTransacao();
	}
	
	public List<E> obterTodos() {
		return this.obterTodos(50, 0);
	}
	
	public List<E> obterTodos(int quantidade, int deslocamento) {
		if(classe == null) {
			System.out.println("PROBLEMA:" + classe);
			throw new UnsupportedOperationException("Classe nula");
		}
		
		String jpql = "SELECT e FROM " + classe.getName().toString() + " e";
		
		TypedQuery<E> query = entityManager.createQuery(jpql, classe);
		query.setMaxResults(quantidade);
		query.setFirstResult(deslocamento);
		
		return query.getResultList();
	}
	
	// Named Query - chamado por arquivo .xml
	public List<E> consulta(String nomeConsulta) {
		TypedQuery<E> query = entityManager.createNamedQuery(nomeConsulta, classe);
		return query.getResultList();
	}
	
	public void fechar() {
		entityManager.close();
	}

	
	// Getters & Setters
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		DAO.entityManagerFactory = entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<E> getClasse() {
		return classe;
	}

	public void setClasse(Class<E> classe) {
		this.classe = classe;
	}

}
