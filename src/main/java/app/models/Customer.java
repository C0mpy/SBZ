package app.models;

import javax.persistence.Entity;

@Entity
public class Customer extends User {
	
	String address;
	int points;

}
