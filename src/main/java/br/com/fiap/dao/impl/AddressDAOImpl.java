/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class AddressDAOImpl.java
 * @description: 
 * @author daniloboccomino - RM85473
 * @since Jun 7, 2021
 */

package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AddressDAO;
import br.com.fiap.entity.Address;

public class AddressDAOImpl extends GenericDAOImpl<Address, Integer> implements AddressDAO {

	public AddressDAOImpl(EntityManager em) {
		super(em);
	}

}
