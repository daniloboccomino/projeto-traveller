/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class CommitException.java
 * @description: exception para commit no banco
 * @author daniloboccomino - RM85473
 * @since Apr 14, 2021
 */

package br.com.fiap.exception;

public class CommitException extends Exception {
	
	public CommitException() {
		super("Erro ao realizar o commit");
	}
	
	public CommitException(String msg) {
		super(msg);
	}

}
