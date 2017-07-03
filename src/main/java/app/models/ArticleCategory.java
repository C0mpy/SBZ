package app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ArticleCategory {

	@Id
	@GeneratedValue
	Long id;
	String name;
	int maxDiscount;
	
	@ManyToOne
	ArticleCategory superCategory;
	
	
}
