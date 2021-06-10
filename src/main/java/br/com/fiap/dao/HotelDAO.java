/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class HotelDAO.java
 * @description: 
 * @author daniloboccomino - RM85473
 * @since Jun 7, 2021
 */

package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Hotel;

public interface HotelDAO extends GenericDAO<Hotel, Integer> {
	
	List<Hotel> searchByName(String name);
	
	List<Hotel> searchByCity(String city);

}
