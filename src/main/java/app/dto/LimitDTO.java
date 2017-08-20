package app.dto;

public class LimitDTO {
	
	int id;
	int fromLimit;
	int toLimit;
	int priceToPoints;
	
	public LimitDTO() {
		super();
	}

	public LimitDTO(int id, int fromLimit, int toLimit, int priceToPoints) {
		super();
		this.id = id;
		this.fromLimit = fromLimit;
		this.toLimit = toLimit;
		this.priceToPoints = priceToPoints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFromLimit() {
		return fromLimit;
	}

	public void setFromLimit(int fromLimit) {
		this.fromLimit = fromLimit;
	}

	public int getToLimit() {
		return toLimit;
	}

	public void setToLimit(int toLimit) {
		this.toLimit = toLimit;
	}

	public int getPriceToPoints() {
		return priceToPoints;
	}

	public void setPriceToPoints(int priceToPoints) {
		this.priceToPoints = priceToPoints;
	}

	@Override
	public String toString() {
		return "LimitDTO [id=" + id + ", fromLimit=" + fromLimit + ", toLimit=" + toLimit + ", priceToPoints="
				+ priceToPoints + "]";
	}
	

}
