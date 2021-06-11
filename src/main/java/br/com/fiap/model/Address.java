package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {
	
	@Id
	@Column(name = "cd_address")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ds_address")
	private String address;
	
	@Column(name = "ds_neighborhood")
	private String neighborhood;
	
	@Column(name = "nm_city")
	private String city;
	
	@Column(name = "nm_state")
	private String state;
	
	@Column(name = "nm_country")
	private String country;
	
	public Address() {}
	
	public Address(String address, String neighborhood, String city, String state, String country) {
		this.address = address;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
