package app.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	String code;
	String name;
	@OneToMany
	List<SpendingLimit> limits;

}
