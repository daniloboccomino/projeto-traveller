/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class BedroomDAO.java
 * @description: 
 * @author daniloboccomino - RM85473
 * @since Jun 7, 2021
 */

package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Bedroom;

public interface BedroomDAO extends GenericDAO<Bedroom, Integer> {
	
	List<Bedroom> searchByPriceLower(double price);

}
