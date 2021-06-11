package br.com.fiap.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

public class GenericDAO<E, K>{
	
	protected EntityManager em;	
	private Class<E> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAO(EntityManager em) {
		this.em = em;
		this.clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void insert(E entity) throws CommitException {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.clear();
	}

	public E select(K id) throws EntityNotFoundException {
		E entity = em.find(clazz, id);
		if (entity == null) throw new EntityNotFoundException();
		return entity;
	}

	public void update(E entity) throws CommitException {
		em.getTransaction().begin();
		em.merge(entity);
		em.flush();
		em.getTransaction().commit();
	}

	public void delete(K id) throws EntityNotFoundException, CommitException {
		em.getTransaction().begin();
		E entity = select(id);
		em.remove(entity);
		em.getTransaction().commit();
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
	}

}
