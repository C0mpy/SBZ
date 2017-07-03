package app.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sale {
	
	@Id
	@GeneratedValue
	Long id;
	String name;
	Date fromDate;
	Date toDate;
	int discount;
	@OneToMany
	List<ArticleCategory> categories;

}
