package mypackage;

public class Product {
	
	private double price;
	private String description;
	
	
	/**
	 * Creates a new product
	 * @param price the product price
	 * @param description the product description
	 */
	public Product(double price, String description) {
		this.price = price;
		this.description = description;
	}

	/**
	 * @return the product price
	 */
	public double getPrice() {
		return price;
	}

//	/**
//	 * @param price the product price
//	 */
//	public void setPrice(double price) {
//		this.price = price;
//	}

	/**
	 * @return the product description
	 */
	public String getDescription() {
		return description;
	}

//	/**
//	 * @param description the product description
//	 */
//	public void setDescription(String description) {
//		this.description = description;
//	}
	
	

}
