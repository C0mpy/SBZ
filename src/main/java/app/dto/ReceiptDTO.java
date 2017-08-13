package app.dto;

import java.util.Date;
import java.util.List;


import app.models.Customer;
import app.models.Item;

public class ReceiptDTO {
	
	String code;
	Date date;
	Customer customer;
	double totalPrice;
	List<Item> items;
	
	public ReceiptDTO() {
		super();
	}

	public ReceiptDTO(String code, Date date, Customer customer, double totalPrice, List<Item> items) {
		super();
		this.code = code;
		this.date = date;
		this.customer = customer;
		this.totalPrice = totalPrice;
		this.items = items;
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

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ReceiptDTO [code=" + code + ", date=" + date + ", customer=" + customer + ", totalPrice=" + totalPrice
				+ ", items=" + items + "]";
	}
	
}
