package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.model.Bedroom;

public class BedroomDAO extends GenericDAO<Bedroom, Integer> {

	public BedroomDAO(EntityManager em) {
		super(em);
	}

	public List<Bedroom> searchByPriceLower(double price) {
		return em.createNamedQuery("Bedroom.porPrecoMenor", Bedroom.class).setParameter("preco", price).getResultList();
	}

}
