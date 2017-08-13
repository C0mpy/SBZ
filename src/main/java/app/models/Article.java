package app.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Article {

	@Id
	String code;
	String name;
	double price;
	int count;
	Date created;
	boolean ordered;
	int minCount;
	String status;
	String picture;
	@ManyToOne(cascade = CascadeType.ALL)
	ArticleCategory category;

	public Article() {
		super();
	}

	public Article(String code, String name, double price, int count, Date created, boolean ordered, int minCount,
			String status, String picture, ArticleCategory category) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.count = count;
		this.created = created;
		this.ordered = ordered;
		this.minCount = minCount;
		this.status = status;
		this.picture = picture;
		this.category = category;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public boolean isOrdered() {
		return ordered;
	}

	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}

	public int getMinCount() {
		return minCount;
	}

	public void setMinCount(int minCount) {
		this.minCount = minCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public ArticleCategory getCategory() {
		return category;
	}

	public void setCategory(ArticleCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Article [code=" + code + ", name=" + name + ", price=" + price + ", count=" + count + ", created="
				+ created + ", ordered=" + ordered + ", minCount=" + minCount + ", status=" + status + ", picture="
				+ picture + ", category=" + category + "]";
	}

	
}
