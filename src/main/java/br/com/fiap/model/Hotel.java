package br.com.fiap.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "Hotel.porNome", query = "select h from Hotel h where lower(h.name) like :nome"),
	@NamedQuery(name = "Hotel.porCidade", query = "select h from Hotel h where lower(h.address.city) like :cidade")
})

@Entity
@Table(name = "HOTEL")
public class Hotel {
	
	@Id
	@Column(name = "cd_hotel")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "cd_address")
	private Address address;
	
	@Column(name = "nm_hotel")
	private String name;
	
	@Column(name = "ds_image_link")
	private String imageLink;
	
	@Column(name = "ds_oficial_link")
	private String oficialLink;
	
	@Column(name = "ds_hotel")
	private String description;
	
	@Column(name = "nr_phone")
	private String number;
	
	@Column(name = "ds_email")
	private String email;
	
	public Hotel() {}
	
	public Hotel(Address address, String name, String imageLink, String oficialLink, String description, String number, String email) {
		this.address = address;
		this.name = name;
		this.imageLink = imageLink;
		this.oficialLink = oficialLink;
		this.description = description;
		this.number = number;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getOficialLink() {
		return oficialLink;
	}

	public void setOficialLink(String oficialLink) {
		this.oficialLink = oficialLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
