package app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SpendingLimit {
	
	@Id
	@GeneratedValue
	Long id;
	double fromLimit;
	double toLimit;
	
}
