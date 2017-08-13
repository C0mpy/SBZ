package app.dto;

public class FilterDTO {
	
	private String code;
	private String name;
	private Double minPrice;
	private Double maxPrice;
	private String category;
	private String status;
	private int page;
	private int count;
	
	public FilterDTO() {
		super();
	}

	public FilterDTO(String code, String name, Double minPrice, Double maxPrice, String category, String status,
			int page, int count) {
		super();
		this.code = code;
		this.name = name;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.category = category;
		this.status = status;
		this.page = page;
		this.count = count;
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

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "FilterDTO [code=" + code + ", name=" + name + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice
				+ ", category=" + category + ", status=" + status + ", page=" + page + ", count=" + count + "]";
	}	
	
	
}
