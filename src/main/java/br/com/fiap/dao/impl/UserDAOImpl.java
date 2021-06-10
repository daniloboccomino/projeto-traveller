/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class UserDAOImpl.java
 * @description: 
 * @author daniloboccomino - RM85473
 * @since Jun 7, 2021
 */

package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.entity.User;

public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO{

	public UserDAOImpl(EntityManager em) {
		super(em);
	}

}
