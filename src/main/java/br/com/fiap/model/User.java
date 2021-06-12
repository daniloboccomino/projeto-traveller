package br.com.fiap.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_birth_date")
	private Date birthdate;

	public User() {}

	public User(String name, String email, String password, Date birthdate) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthdate = birthdate;
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
}
