package br.com.fiap.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.fiap.dao.BedroomDAO;
import br.com.fiap.model.Bedroom;
import br.com.fiap.util.EntityManagerFacade;

@Named
@RequestScoped
public class BedroomBean {

	private Bedroom bedroom = new Bedroom();
	
	private EntityManager manager = new EntityManagerFacade().getEntityManager();
	
	private BedroomDAO bedroomDAO = new BedroomDAO(manager);
	
	public List<Bedroom> getBedroomsByPriceLower(){
		return bedroomDAO.searchByPriceLower(bedroom.getPrice());
	}
	
	public Bedroom getBedroom() {
		return bedroom;
	}
	
	public void setBedroom(Bedroom bedroom) {
		this.bedroom = bedroom;
	}
	
	
}
