/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 * 
 * @class GenericDaoImpl.java
 * @description: implementacao de dao generico para metodos sql
 * @author daniloboccomino - RM85473
 * @since Apr 14, 2021
 */

package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

public class GenericDAOImpl<E, K> implements GenericDAO<E, K> {
	
	protected EntityManager em;	
	private Class<E> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public void insert(E entity) {
		em.persist(entity);
	}

	@Override
	public E select(K id) throws EntityNotFoundException {
		E entity = em.find(clazz, id);
		if (entity == null) throw new EntityNotFoundException();
		return entity;
	}

	@Override
	public void update(E entity) {
		em.merge(entity);
	}

	@Override
	public void delete(K id) throws EntityNotFoundException {
		E entity = select(id);
		em.remove(entity);		
	}

	@Override
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
