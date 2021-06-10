/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class Bedroom.java
 * @description: entidade Bedroom no banco de dados
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "Bedroom.porPrecoMenor", query = "select b from Bedroom b where b.price <= :preco order by b.price"),
})

@Entity
@Table(name = "T_BEDROOM")
@SequenceGenerator(name = "bedroom", sequenceName = "SQ_T_BEDROOM", allocationSize = 1)
public class Bedroom {
	
	@Id
	@Column(name = "cd_bedroom")
	@GeneratedValue(generator = "bedroom", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "cd_hotel")
	private Hotel hotel;
	
	@Column(name = "vl_price")
	private Double price;
	
	@Column(name = "nm_bedroom")
	private String name;
	
	@Column(name = "nr_guest")
	private int guests;
	
	@Column(name = "ds_bedroom")
	private String description;
	
	public Bedroom() {}
	
	public Bedroom(Double price, String name, int guests, String description) {
		this.price = price;
		this.name = name;
		this.guests = guests;
		this.description = description;
	}

	public Bedroom(Hotel hotel, Double price, String name, int guests, String description) {
		this.hotel = hotel;
		this.price = price;
		this.name = name;
		this.guests = guests;
		this.description = description;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGuests() {
		return guests;
	}

	public void setGuests(int guests) {
		this.guests = guests;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
