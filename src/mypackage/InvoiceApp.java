package mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		double taxRate; // one tax rate for all products, entered as a percentage (ie 3 for 3%)
		boolean addMoreProducts = true; // false when user chooses to stop entering products
		List<Product> products = new ArrayList<Product>(); // holds all users products
		double price = 0; // product price
		String descr; // product description
		double subTotal = 0; // total before tax
		double grandTotal = 0; // total with tax
		double taxTotal = 0; // total of tax only
		final double maxPrice = 1000000; // max price allowed to be entered by user
		
		boolean inputError = false; // set to true if user enters invalid input anywhere
		
		
		System.out.println("Enter the tax rate (ie 3 for 3%): ");
		taxRate = scanner.nextDouble(); // store tax rate
		scanner.nextLine(); // consume the dangling \n
		taxRate /= 100; // convert to decimal
		
		// continue asking user for more products until they say stop
		// assume they will add at least one product
		do {

			price = getPrice(scanner, maxPrice);
//			do {
//				try { // get price and make sure it's a number
//					inputError = false;
//					System.out.println("Enter product price: ");
//					price = scanner.nextDouble();
//					if(price > maxPrice) {
//						throw new Exception();
//					}
//				} catch(Exception e) { // user did not enter a number
//					scanner.nextLine(); // consume the dangling \n or it loops forever
//					inputError = true;
//					System.out.printf("Please enter a number less than %.2f\n", maxPrice);
//				};
//			} while(inputError);
			
			
			
			// get and temporarily store the description
			System.out.println("Enter product description: ");
			descr = scanner.nextLine();
		
			// create a new Product object and add it to our product list
			products.add(new Product(price, descr));
		
			// ask if user wants to add more products
			System.out.println("Would you like to add another product? Y/N");
			addMoreProducts = scanner.nextLine().equalsIgnoreCase("y") ? true : false;
		} while(addMoreProducts);
		
		
		// display a thank you and summary message
		System.out.println("Thank you for ordering products with us!");
		System.out.println("Following is a summary of your order:\n");
		
		// display order summary table headers
		System.out.printf("%-32s %-16s\n", "DESCRIPTION", "PRICE");
		System.out.println("----------------------------------------------");
		
		// sum up the sub total and display the product info
		// NOTE: make sure the format string spacing is same as table headers above
		for(Product p : products) {
			subTotal += p.getPrice();
			System.out.printf("%-32s $%-16.2f\n", p.getDescription(), p.getPrice());
		}
		
		// calculate the tax 
		taxTotal = subTotal * taxRate;
		
		// calculate grand total
		grandTotal = subTotal + taxTotal;
		
		// display tax and grand total
		// format strings are amazing!
		System.out.printf("\nTax rate: %.0f%%\n", taxRate * 100);
		System.out.printf("Tax charged: $%.2f\n", taxTotal);
		System.out.printf("Total amount due: $%.2f", grandTotal);
				
		
	}
	
	
	// gets price from user and validates input
	// checks for not a number and number too large
	private static double getPrice(Scanner scanner, double maxPrice) {
		boolean inputError = false;
		double price = 0;
		
		do {
			try { // get price and make sure it's a number not greater than maxPrice
				inputError = false;
				System.out.println("Enter product price: ");
				price = scanner.nextDouble();
				if(price > maxPrice) { // user entered number that was too large
					throw new Exception();
				}
				scanner.nextLine(); // Scanner is kind of annoying
				
			} catch(Exception e) { // user did not enter a number
				scanner.nextLine(); // consume the dangling \n or it loops forever
				inputError = true;
				System.out.printf("Please enter a number less than %.2f\n", maxPrice);
			};
		} while(inputError);
		
		return price;
	}
	

}
