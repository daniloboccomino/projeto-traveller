package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.model.User;

public class UserDAO extends GenericDAO<User, Integer>{

	public UserDAO(EntityManager em) {
		super(em);
	}
	
	public boolean findByEmailAndPassword(String email, String password) {
		try {
			em.createNamedQuery("User.byEmailAndByPassword", User.class).setParameter("email", email).setParameter("password", password).getSingleResult();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
