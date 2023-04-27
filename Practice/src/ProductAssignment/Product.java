package ProductAssignment;

public class Product {
	
	// Fields -> Product name, product description, product price and rating
	
	
	private String productName,productDescription;
	private float rating;
	private double price;
	public Product(String productName, String productDescription, float rating, double price) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.rating = rating;
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

}
