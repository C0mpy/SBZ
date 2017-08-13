package app.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SpendingLimit {
	
	@Id
	@GeneratedValue
	Long id;
	double fromLimit;
	double toLimit;
	// procenat cene koji pretvaramo u nagradne poene
	int priceToPoints;
	
	public SpendingLimit() {
		super();
	}

	public SpendingLimit(Long id, double fromLimit, double toLimit, int priceToPoints) {
		super();
		this.id = id;
		this.fromLimit = fromLimit;
		this.toLimit = toLimit;
		this.priceToPoints = priceToPoints;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getFromLimit() {
		return fromLimit;
	}

	public void setFromLimit(double fromLimit) {
		this.fromLimit = fromLimit;
	}

	public double getToLimit() {
		return toLimit;
	}

	public void setToLimit(double toLimit) {
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
		return "SpendingLimit [id=" + id + ", fromLimit=" + fromLimit + ", toLimit=" + toLimit + ", priceToPoints="
				+ priceToPoints + "]";
	}
	
	
}
