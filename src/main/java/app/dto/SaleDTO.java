package app.dto;

import java.util.ArrayList;
import java.util.Date;

public class SaleDTO {
	
	String code;
	String name;
	Date fromDate;
	Date toDate;
	int discount;
	ArrayList<String> categories;
	
	public SaleDTO() {
		super();
	}

	public SaleDTO(String code, String name, Date fromDate, Date toDate, int discount, ArrayList<String> categories) {
		super();
		this.code = code;
		this.name = name;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.discount = discount;
		this.categories = categories;
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

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public ArrayList<String> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "SaleDTO [code=" + code + ", name=" + name + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", discount=" + discount + ", categories=" + categories + "]";
	}

}
