/**
 * Digital Business Enablement
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Joao Carlos Lima e Silva
 *
 * @class EntityManagerFacade.java
 * @description:
 * @author daniloboccomino - RM85473
 * @since Apr 13, 2021
 */

package br.com.fiap.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFacade {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("traveller-persistence-unit");
		return emf.createEntityManager();
	}

}
