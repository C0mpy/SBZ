package app.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {

	enum Status {
		ACTIVE,
		ARCHIVE
	}
	
	@Id
	@GeneratedValue
	Long id;
	String name;
	double price;
	int count;
	Date created;
	boolean ordered;
	int minCount;
	Status status;
	
}
