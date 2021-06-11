package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.model.Address;

public class AddressDAO extends GenericDAO<Address, Integer> {

	public AddressDAO(EntityManager em) {
		super(em);
	}

}
