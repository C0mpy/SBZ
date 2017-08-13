package app.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import app.dto.ReceiptDTO;

@Entity
public class Receipt {
	
	@Id
	String code;
	Date date;
	@ManyToOne
	Customer customer;
	double totalPrice;
	int discount;
	@OneToMany
	List<ReceiptDiscount> discounts;
	double finalPrice;
	int spentPoints;
	int earnedPoints;
	@OneToMany
	List<Item> items;
	String state;
	
	public Receipt() {
		super();
	}

	public Receipt(String code, Date date, Customer customer, double totalPrice, int discount,
			List<ReceiptDiscount> discounts, double finalPrice, int spentPoints, int earnedPoints, List<Item> items,
			String state) {
		super();
		this.code = code;
		this.date = date;
		this.customer = customer;
		this.totalPrice = totalPrice;
		this.discount = discount;
		this.discounts = discounts;
		this.finalPrice = finalPrice;
		this.spentPoints = spentPoints;
		this.earnedPoints = earnedPoints;
		this.items = items;
		this.state = state;
	}

	public Receipt(Customer customer) {
		super();
		this.code = UUID.randomUUID().toString();
		this.date = new Date();
		this.customer = customer;
		this.state = "NEW";
		this.items = new ArrayList<Item>();
		this.discounts = new ArrayList<ReceiptDiscount>();
	}
	
	public Receipt(ReceiptDTO receiptDTO) {
		this.code = receiptDTO.getCode();
		this.date = receiptDTO.getDate();
		this.customer = receiptDTO.getCustomer();
		this.totalPrice = receiptDTO.getTotalPrice();
		this.discount = 0;
		this.discounts = new ArrayList<ReceiptDiscount>();
		this.finalPrice = 0;
		this.spentPoints = 0;
		this.earnedPoints = 0;
		this.items = receiptDTO.getItems();
		this.state = "NEW";
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double d) {
		this.totalPrice = d;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public List<ReceiptDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<ReceiptDiscount> discounts) {
		this.discounts = discounts;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public int getSpentPoints() {
		return spentPoints;
	}

	public void setSpentPoints(int spentPoints) {
		this.spentPoints = spentPoints;
	}

	public int getEarnedPoints() {
		return earnedPoints;
	}

	public void setEarnedPoints(int earnedPoints) {
		this.earnedPoints = earnedPoints;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Receipt [code=" + code + ", date=" + date + ", customer=" + customer + ", totalPrice=" + totalPrice
				+ ", discount=" + discount + ", discounts=" + discounts + ", finalPrice=" + finalPrice
				+ ", spentPoints=" + spentPoints + ", earnedPoints=" + earnedPoints + ", items=" + items + ", state="
				+ state + "]";
	}
}
