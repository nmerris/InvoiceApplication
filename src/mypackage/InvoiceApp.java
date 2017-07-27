package mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		double taxRate; // one tax rate for all products
		boolean addMoreProducts = true; // set to false if user chooses to stop entering products
		List<Product> products = new ArrayList<Product>(); // holds all users products
		double price; // product price
		String descr; // product description
		
		System.out.println("Enter the tax rate: ");
		taxRate = scanner.nextDouble(); // store tax rate
		scanner.nextLine(); // consume the dangling \n
		
		// continue asking user for more products until they say stop
		// assume they will add at least one product
		do {
			// get and temporarily store the price
			System.out.println("Enter product price: ");
			price = scanner.nextDouble();
			scanner.nextLine();
			
			// get and temporarily store the description
			System.out.println("Entere product description: ");
			descr = scanner.nextLine();
			
			// create a new product object
			Product currentProduct = new Product(price, descr);
		
			// add it to our product list
			products.add(currentProduct);
		
		
		
		
		
			System.out.println("Would you like to add another product? Y/N");
			addMoreProducts = scanner.nextLine().equalsIgnoreCase("y") ? true : false;
		} while(addMoreProducts);
		
		
		
		

	}

}
