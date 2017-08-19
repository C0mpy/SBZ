package app.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@DiscriminatorValue(value = "Customer")
public class Customer extends User {
	
	String address;
	int points;
	@ManyToOne
	Category category;
	@OneToMany(fetch = FetchType.EAGER)
	@JsonBackReference
	List<Receipt> receipts;
	
	public Customer() {
		super();
	}
	
	public Customer(String address, int points, Category category, List<Receipt> receipts) {
		super();
		this.address = address;
		this.points = points;
		this.category = category;
		this.receipts = receipts;
	}

	public Customer(String username, String password, String firstName, String lastName, String picture, String address, Category category, List<Receipt> receipts) {
		super(username, password, firstName, lastName, picture);
		this.address = address;
		this.points = 0;
		this.category = category;
		this.receipts = receipts;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Receipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(List<Receipt> receipts) {
		this.receipts = receipts;
	}

	@Override
	public String toString() {
		return "Customer [address=" + address + ", points=" + points + ", category=" + category + ", receipts="
				+ receipts + "]";
	}

	
}
