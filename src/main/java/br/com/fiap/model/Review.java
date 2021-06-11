package br.com.fiap.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.primefaces.shaded.json.JSONPropertyIgnore;

@Entity
@Table(name = "REVIEW")
public class Review {
	
	@Id
	@Column(name = "cd_review")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "cd_user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "cd_hotel")
	private Hotel hotel;
	
	@Column(name = "vl_review")
	private Double value;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_review")
	private Calendar date;
	
	@Column(name = "ds_comment")
	private String comment;
	
	public Review() {}

	public Review(User user, Hotel hotel, Double value, Calendar date, String comment) {
		this.user = user;
		this.hotel = hotel;
		this.value = value;
		this.date = date;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JSONPropertyIgnore()
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
