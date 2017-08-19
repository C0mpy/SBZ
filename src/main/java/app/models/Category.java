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
	
	public Category() {
		super();
	}

	public Category(String code, String name, List<SpendingLimit> limits) {
		super();
		this.code = code;
		this.name = name;
		this.limits = limits;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SpendingLimit> getLimits() {
		return limits;
	}

	public void setLimits(List<SpendingLimit> limits) {
		this.limits = limits;
	}

}
