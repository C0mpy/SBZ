package app.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Receipt {
	
	enum State {
		ORDERED,
		CANCELED,
		DONE
	}
	
	@Id
	String code;
	Date date;
	@ManyToOne
	Customer customer;
	float totalPrice;
	@ManyToOne
	Discount totalDiscount;
	double finalPrice;
	int spentPoints;
	int earnedPoints;
	@OneToMany
	List<Item> items;
	State state;

}
