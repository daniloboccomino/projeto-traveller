/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class Review.java
 * @description: entidade Review no banco de dados
 * @author daniloboccomino - RM85473
 * @since Jun 7, 2021
 */

package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "T_REVIEW")
@SequenceGenerator(name = "review", sequenceName = "SQ_T_REVIEW", allocationSize = 1)
public class Review {
	
	@Id
	@Column(name = "cd_review")
	@GeneratedValue(generator = "review", strategy = GenerationType.SEQUENCE)
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
