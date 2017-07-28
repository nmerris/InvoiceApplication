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
		double subTotal = 0; // total before tax
		double grandTotal = 0; // total with tax
		double taxTotal = 0; // total of tax only
		
		
		
		System.out.println("Enter the tax rate (ie 3 for 3%): ");
		taxRate = scanner.nextDouble(); // store tax rate, assume it is an integer, like 3%
		scanner.nextLine(); // consume the dangling \n
		taxRate /= 100; // convert to decimal
		
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
//			Product currentProduct = new Product(price, descr);
		
			// create a new Product object and add it to our product list
			products.add(new Product(price, descr));
		
			// ask if user wants to add more products
			System.out.println("Would you like to add another product? Y/N");
			addMoreProducts = scanner.nextLine().equalsIgnoreCase("y") ? true : false;
		} while(addMoreProducts);
		
		
		
		
		// sum up the sub total and display the product info
		for(Product p : products) {
			subTotal += p.getPrice();
			
			System.out.print(p.getDescription() + "  ");
			System.out.println("$" + p.getPrice());
		}
		
		// calculate the tax 
		taxTotal = subTotal * taxRate;
		
		// calculate grand total
		grandTotal = subTotal + taxTotal;
		
		// display tax and grand total
		// TODO: make it look nice
		System.out.println("Tax charged: $" + taxTotal);
		System.out.println("Total amount due: $" + grandTotal);
		
		
		

	}

}
