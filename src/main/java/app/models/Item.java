package app.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	Long id;
	@ManyToOne
	Receipt receipt;
	int number;
	@ManyToOne
	Article article;
	double articlePrice;
	int amount;
	double totalPrice;
	int discount;
	double finalPrice;
	
}
