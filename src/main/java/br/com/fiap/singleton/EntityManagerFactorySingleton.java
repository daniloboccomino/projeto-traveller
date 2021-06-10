/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class EntityManagerFactorySingleton.java
 * @description: gerencia a uncia instancia da fabrica
 * @author daniloboccomino - RM85473
 * @since Apr 14, 2021
 */

package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
	/**
	 * atributo static que armazena a unica instancia
	 */
	private static EntityManagerFactory emf;
	
	/**
	 * metodo static que cria e retorna a instancia
	 * @return EntityManagerFactory
	 */
	public static EntityManagerFactory getInstance() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("oracle");
		}
		return emf;
	}
	
	private EntityManagerFactorySingleton() {}

}
