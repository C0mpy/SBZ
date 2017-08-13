package app.models;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import app.dto.RegisterDTO;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public class User {
	
	@Id
	@GeneratedValue
	Long id;
	String username;
	String password;
	String firstName;
	String lastName;
	String picture;
	Date registered;

	
	public User() {
		super();
	}
	
	public User(RegisterDTO registerDTO) {
		this.username = registerDTO.getUsername();
		this.password = registerDTO.getPassword();
		this.firstName = registerDTO.getFirstName();
		this.lastName = registerDTO.getLastName();
		this.picture = registerDTO.getPicture();
		this.registered = new Date();
	}
	
	

	public User(String username, String password, String firstName, String lastName, String picture) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.picture = picture;
		this.registered = new Date();
	}

	public User(Long id, String username, String password, String firstName, String lastName, String picture, Date registered) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.picture = picture;
		this.registered = registered;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", picture=" + picture + ", registered=" + registered + "]";
	}
	
}
