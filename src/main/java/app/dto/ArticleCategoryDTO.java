package app.dto;

public class ArticleCategoryDTO {
	
	String code;
	String name;
	int maxDiscount;
	public ArticleCategoryDTO() {
		super();
	}
	public ArticleCategoryDTO(String code, String name, int maxDiscount) {
		super();
		this.code = code;
		this.name = name;
		this.maxDiscount = maxDiscount;
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
	@Override
	public String toString() {
		return "ArticleCategoryDTO [code=" + code + ", name=" + name + ", maxDiscount=" + maxDiscount + "]";
	}

}
