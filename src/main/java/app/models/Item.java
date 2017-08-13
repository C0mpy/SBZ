package app.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	Long id;
	@ManyToOne
	Article article;
	double articlePrice; // on the shopping day
	int amount;
	// ammount * articlePrice
	double totalPrice;
	int discount;
	// ammount * articlePrice * discount/100
	double finalPrice;
	@OneToMany
	List<ItemDiscount> discounts;
	
	public Item() {
		super();
	}

	public Item(Long id, Article article, double articlePrice, int amount, double totalPrice,
			int discount, double finalPrice, List<ItemDiscount> discounts) {
		super();
		this.id = id;
		this.article = article;
		this.articlePrice = articlePrice;
		this.amount = amount;
		this.totalPrice = totalPrice;
		this.discount = discount;
		this.finalPrice = finalPrice;
		this.discounts = discounts;
	}

	public Item(Article article, double articlePrice, int amount, double totalPrice) {
		super();
		this.article = article;
		this.articlePrice = articlePrice;
		this.amount = amount;
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public double getArticlePrice() {
		return articlePrice;
	}

	public void setArticlePrice(double articlePrice) {
		this.articlePrice = articlePrice;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

	public List<ItemDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<ItemDiscount> discounts) {
		this.discounts = discounts;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", article=" + article + ", articlePrice=" + articlePrice
				+ ", amount=" + amount + ", totalPrice=" + totalPrice + ", discount=" + discount + ", finalPrice="
				+ finalPrice + ", discounts=" + discounts + "]";
	}
	
	
}
