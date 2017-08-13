package app.dto;

public class ItemDTO {
	
	String receipt;
	String article;
	double articlePrice;
	int ammount;
	double totalPrice;
	
	public ItemDTO() {
		super();
	}

	public ItemDTO(String receipt, String article, double articlePrice, int ammount, double totalPrice) {
		super();
		this.receipt = receipt;
		this.article = article;
		this.articlePrice = articlePrice;
		this.ammount = ammount;
		this.totalPrice = totalPrice;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public double getArticlePrice() {
		return articlePrice;
	}

	public void setArticlePrice(double articlePrice) {
		this.articlePrice = articlePrice;
	}

	public int getAmmount() {
		return ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "ItemDTO [receipt=" + receipt + ", article=" + article + ", articlePrice=" + articlePrice + ", ammount="
				+ ammount + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
