package app.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sale {
	
	@Id
	String code;
	String name;
	Date fromDate;
	Date toDate;
	int discount;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<ArticleCategory> articleCategories;

	public Sale() {
		super();
	}

	public Sale(String code, String name, Date fromDate, Date toDate, int discount,
			List<ArticleCategory> articleCategories) {
		super();
		this.code = code;
		this.name = name;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.discount = discount;
		this.articleCategories = articleCategories;
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

	public List<ArticleCategory> getArticleCategories() {
		return articleCategories;
	}

	public void setArticleCategories(List<ArticleCategory> articleCategories) {
		this.articleCategories = articleCategories;
	}

	@Override
	public String toString() {
		return "Sale [code=" + code + ", name=" + name + ", fromDate=" + fromDate + ", toDate=" + toDate + ", discount="
				+ discount + "]";
	}

}
