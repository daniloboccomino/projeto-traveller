/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class HotelDAOImpl.java
 * @description: 
 * @author daniloboccomino - RM85473
 * @since Jun 7, 2021
 */

package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.HotelDAO;
import br.com.fiap.entity.Hotel;

public class HotelDAOImpl extends GenericDAOImpl<Hotel, Integer> implements HotelDAO {

	public HotelDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Hotel> searchByName(String name) {
		return em.createNamedQuery("Hotel.porNome", Hotel.class).setParameter("nome", "%"+name.toLowerCase()+"%").getResultList();
	}

	@Override
	public List<Hotel> searchByCity(String city) {
		return em.createNamedQuery("Hotel.porCidade", Hotel.class).setParameter("cidade", "%"+city.toLowerCase()+"%").getResultList();
	}

}
