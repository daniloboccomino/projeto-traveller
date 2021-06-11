/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class ReviewDAOImpl.java
 * @description: 
 * @author daniloboccomino - RM85473
 * @since Jun 7, 2021
 */

package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReviewDAO;
import br.com.fiap.entity.Review;

public class ReviewDAOImpl extends GenericDAOImpl<Review, Integer> implements ReviewDAO {

	public ReviewDAOImpl(EntityManager em) {
		super(em);
	}

}
