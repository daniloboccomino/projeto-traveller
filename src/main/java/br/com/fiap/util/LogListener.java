/**
 * Digital Business Enablement
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Joao Carlos Lima e Silva
 *
 * @class LogListener.java
 * @description: observar as acoes do sistema
 * @author daniloboccomino - RM85473
 * @since May 11, 2021
 */

package br.com.fiap.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LogListener implements PhaseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("AFTER - " + event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("BEFORE - " + event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
