package br.com.fiap.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.fiap.dao.HotelDAO;
import br.com.fiap.model.Address;
import br.com.fiap.model.Hotel;
import br.com.fiap.util.EntityManagerFacade;

@Named
@RequestScoped
public class HotelBean {
	private Hotel hotel = new Hotel();
	
	private Address address = new Address();

	private EntityManager manager = new EntityManagerFacade().getEntityManager();
	
	private HotelDAO hotelDAO = new HotelDAO(manager);
	
	public void save(){
		try {
			hotelDAO.insert(this.hotel);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel cadastrado com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro no cadastro do hotel"));
		}
	}
	
	public List<Hotel> getHotelsByName(){
		if (hotel.getName() == null || hotel.getName().isEmpty()){
			return hotelDAO.searchByName("");
		}
		return hotelDAO.searchByName(hotel.getName());
	}
	
	public List<Hotel> getHotelsByCity(){
		if (address.getCity() == null || address.getCity().isEmpty()){
			return hotelDAO.searchByName("");
		}
		return hotelDAO.searchByCity(hotel.getAddress().getCity());
	}
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
