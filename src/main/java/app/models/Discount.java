package app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Discount {
	
	enum Type {
		BASE,
		ADDITIONAL
	}
	
	@Id
	@GeneratedValue
	Long id;
	int discount;
	Type type;

}
