/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @interface GenericDao.java
 * @description: dao generico para implementacao de metodos sql
 * @author daniloboccomino - RM85473
 * @since Apr 14, 2021
 */

package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

public interface GenericDAO<E, K> {
	
	void insert(E entity);
	E select(K id) throws EntityNotFoundException;
	void update(E entity);
	void delete(K id) throws EntityNotFoundException;
	void commit() throws CommitException;

}
