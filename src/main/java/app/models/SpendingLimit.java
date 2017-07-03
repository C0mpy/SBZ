package app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SpendingLimit {
	
	@Id
	@GeneratedValue
	Long id;
	double fromLimit;
	double toLimit;
	@ManyToOne
	Category category;
	
}
