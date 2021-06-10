/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class BedroomDAOImpl.java
 * @description: 
 * @author daniloboccomino - RM85473
 * @since Jun 7, 2021
 */

package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.BedroomDAO;
import br.com.fiap.entity.Bedroom;

public class BedroomDAOImpl extends GenericDAOImpl<Bedroom, Integer> implements BedroomDAO {

	public BedroomDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Bedroom> searchByPriceLower(double price) {
		return em.createNamedQuery("Bedroom.porPrecoMenor", Bedroom.class).setParameter("preco", price).getResultList();
	}

}
