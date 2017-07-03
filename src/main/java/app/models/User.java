package app.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	Long id;
	String username;
	String pass;
	String firstName;
	String lastName;
	Date registered;

}
