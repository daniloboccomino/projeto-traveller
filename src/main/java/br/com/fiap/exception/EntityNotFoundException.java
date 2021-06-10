/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class EntityNotFoundException.java
 * @description: exception para select no banco
 * @author daniloboccomino - RM85473
 * @since Apr 14, 2021
 */

package br.com.fiap.exception;

public class EntityNotFoundException extends Exception {
	
	public EntityNotFoundException() {
		super("Entidade não encontrada.");
	}
	
	public EntityNotFoundException(String msg) {
		super(msg);
	}

}
