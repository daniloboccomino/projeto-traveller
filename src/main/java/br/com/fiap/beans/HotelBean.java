package br.com.fiap.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.fiap.dao.HotelDAO;
import br.com.fiap.model.Hotel;
import br.com.fiap.util.EntityManagerFacade;

@Named
@RequestScoped
public class HotelBean {
	private Hotel hotel = new Hotel();

	private EntityManager manager = new EntityManagerFacade().getEntityManager();
	
	private HotelDAO hotelDAO = new HotelDAO(manager);
	
	public void save(){
		try {
			hotelDAO.insert(this.hotel);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário cadastro com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro no cadastro de usuário!"));
		}
	}
	
	public List<Hotel> searchByName(String name){
		return hotelDAO.searchByName(name);
	}
	
	public List<Hotel> searchByCity(String city){
		return hotelDAO.searchByCity(city);
	}
}
