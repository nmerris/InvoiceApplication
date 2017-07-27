package mypackage;

import java.util.Scanner;

public class InvoiceApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		double taxRate; // one tax rate for all products
		boolean addMoreProducts = true; // set to false if user chooses to stop entering products
		
		
		System.out.println("Enter the tax rate: ");
		taxRate = scanner.nextDouble(); // store tax rate
		scanner.nextLine(); // consume the dangling \n
		
		// continue asking user for more products until they say stop
		do {
			// TODO: get 'er done
		
		
		
		
		
		
			System.out.println("Would you like to add another product? Y/N");
			addMoreProducts = scanner.nextLine().equalsIgnoreCase("y") ? true : false;
		} while(addMoreProducts);
		
		
		
		

	}

}
