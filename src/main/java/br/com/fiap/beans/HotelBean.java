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
	
	private List<Hotel> hotels = hotelDAO.searchByName("");
	
	public void save(){
		try {
			hotelDAO.insert(this.hotel);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel cadastrado com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro no cadastro do hotel"));
		}
	}
	
	public void hotelsByName(){
		if (hotel.getName() == null || hotel.getName().isEmpty()){
			hotels = hotelDAO.searchByName("");
		}
		hotels = hotelDAO.searchByName(hotel.getName());
	}
	
	public void hotelsByCity(){
		if (address.getCity() == null || address.getCity().isEmpty()){
			hotels = hotelDAO.searchByName("");
		}
		hotels = hotelDAO.searchByCity(hotel.getAddress().getCity());
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
	
	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
	
}
