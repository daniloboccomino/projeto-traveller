package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.model.Hotel;

public class HotelDAO extends GenericDAO<Hotel, Integer> {

	public HotelDAO(EntityManager em) {
		super(em);
	}

	public List<Hotel> searchByName(String name) {
		return em.createNamedQuery("Hotel.porNome", Hotel.class).setParameter("nome", "%"+name.toLowerCase()+"%").getResultList();
	}

	public List<Hotel> searchByCity(String city) {
		return em.createNamedQuery("Hotel.porCidade", Hotel.class).setParameter("cidade", "%"+city.toLowerCase()+"%").getResultList();
	}

}
