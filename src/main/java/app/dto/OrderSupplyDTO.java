package app.dto;

public class OrderSupplyDTO {
	
	String code;
	Integer amount;
	
	public OrderSupplyDTO() {
		super();
	}
	public OrderSupplyDTO(String code, Integer amount) {
		super();
		this.code = code;
		this.amount = amount;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "OrderSupplyDTO [code=" + code + ", amount=" + amount + "]";
	}

}
