package app.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ReceiptDiscount {
	
	@Id
	String code;
	int discount;
	String type;
	String description;
	@ManyToOne
	Receipt receipt;
	
	public ReceiptDiscount() {
		super();
	}

	public ReceiptDiscount(String code, int discount, String type, String description, Receipt receipt) {
		super();
		this.code = code;
		this.discount = discount;
		this.type = type;
		this.description = description;
		this.receipt = receipt;
	}

	public ReceiptDiscount(int discount, String type, String description, Receipt receipt) {
		super();
		this.code = UUID.randomUUID().toString();
		this.discount = discount;
		this.type = type;
		this.description = description;
		this.receipt = receipt;
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

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	@Override
	public String toString() {
		return "ReceiptDiscount [code=" + code + ", discount=" + discount + ", type=" + type + ", description="
				+ description + "]";
	}
	
	
}
