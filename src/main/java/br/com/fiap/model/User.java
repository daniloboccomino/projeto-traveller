package br.com.fiap.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@NamedQueries({
	@NamedQuery(name = "User.byEmailAndByPassword", query = "SELECT u FROM User u WHERE u.email=:email AND u.password=:password")
})

@Entity
@Table(name = "T_USER")
public class User {
	
	@Id
	@Column(name = "cd_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nm_user")
	private String name;
	
	@Column(name = "ds_email")
	private String email;
	
	@Column(name = "ds_password")
	private String password;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_birth_date")
	private Calendar birthdate;
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Review> reviews;
	
	public User() {}

	public User(String name, String email, String password, Calendar birthdate) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthdate = birthdate;
	}
	
	public void addReview(Review review) {
		if (reviews == null) {
			reviews = new ArrayList<Review>();
		}
		review.setUser(this);
		reviews.add(review);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Calendar getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Calendar birthdate) {
		this.birthdate = birthdate;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
}