package app.dto;

import java.util.ArrayList;
public class OrderDTO {
	
	String receiptCode;
	Integer points;
	
	public OrderDTO() {
		super();
	}

	public OrderDTO(String receiptCode, Integer points) {
		super();
		this.receiptCode = receiptCode;
		this.points = points;
	}

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "OrderDTO [receiptCode=" + receiptCode + ", points=" + points + "]";
	}

}
