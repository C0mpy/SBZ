package app.dto;

import java.util.Date;
import java.util.List;


import app.models.Customer;
import app.models.Item;
import app.models.Receipt;

public class ReceiptDTO {
	
	String code;
	String state;
	Date date;
	double totalPrice;
	int discount;
	double finalPrice;
	
	public ReceiptDTO() {
		super();
	}
	
	public ReceiptDTO(Receipt r) {
		this.code = r.getCode();
		this.state = r.getState();
		this.date = r.getDate();
		this.totalPrice = r.getTotalPrice();
		this.discount = r.getDiscount();
		this.finalPrice = r.getFinalPrice();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	
}
