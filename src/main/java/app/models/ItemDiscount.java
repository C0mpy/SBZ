package app.models;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ItemDiscount {
	
	@Id
	String code;
	int discount;
	String type;
	String description;
	@ManyToOne
	Item item;
	
	public ItemDiscount() {
		super();
	}

	public ItemDiscount(String code, int discount, String type, String description, Item item) {
		super();
		this.code = code;
		this.discount = discount;
		this.type = type;
		this.description = description;
		this.item = item;
	}
	
	public ItemDiscount(int discount, String type, String description, Item item) {
		super();
		this.code = UUID.randomUUID().toString();
		this.discount = discount;
		this.type = type;
		this.description = description;
		this.item = item;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ItemDiscount [code=" + code + ", discount=" + discount + ", type=" + type + ", description="
				+ description + "]";
	}
	
	
}

