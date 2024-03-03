package core;

public class DefaultProduct implements Product {
	int id;
	String productName;
	String categoryName;
	double price;

	

	public DefaultProduct(int id, String productName, String categoryName, double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product id=" + id + ", product name=" + productName
				+ ", category name=" + categoryName + ", price=" + price;
	}

	
}
