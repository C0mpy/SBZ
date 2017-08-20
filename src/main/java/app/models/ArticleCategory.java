package app.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import app.dto.ArticleCategoryDTO;

@Entity
public class ArticleCategory {

	@Id
	String code;
	String name;
	int maxDiscount;
	@JsonIgnore
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	List<Article> articles;
	@JsonIgnore
	@ManyToOne
	ArticleCategory superCategory;
	@ManyToMany(mappedBy = "articleCategories", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Sale> sales;
	
	public ArticleCategory() {
		super();
	}
						
	public ArticleCategory(String code, String name, int maxDiscount, ArrayList<Article> articles,
			ArticleCategory superCategory, ArrayList<Sale> arrayList) {
		super();
		this.code = code;
		this.name = name;
		this.maxDiscount = maxDiscount;
		this.articles = articles;
		this.superCategory = superCategory;
		this.sales = arrayList;
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

	public int getMaxDiscount() {
		return maxDiscount;
	}

	public void setMaxDiscount(int maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public ArticleCategory getSuperCategory() {
		return superCategory;
	}

	public void setSuperCategory(ArticleCategory superCategory) {
		this.superCategory = superCategory;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "ArticleCategory [code=" + code + ", name=" + name + ", maxDiscount=" + maxDiscount + ", superCategory=" + superCategory + ", sales=" + sales + "]";
	}

	
}
