/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class Address.java
 * @description: entidade Address no banco de dados
 * @author daniloboccomino - RM85473
 * @since Jun 7, 2021
 */

package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_ADDRESS")
@SequenceGenerator(name = "address", sequenceName = "SQ_T_ADDRESS", allocationSize = 1)
public class Address {
	
	@Id
	@Column(name = "cd_address")
	@GeneratedValue(generator = "address", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@OneToOne(mappedBy = "address", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Hotel hotel;
	
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

	public Address(Hotel hotel, String address, String neighborhood, String city, String state, String country) {
		this.hotel = hotel;
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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
