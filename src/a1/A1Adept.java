package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int totalItemsStocked = scan.nextInt();
		
		Item[] inventory = new Item[totalItemsStocked];
		
		for (int i = 0; i < inventory.length; i++) {
			Item item = new Item(0,
					scan.next(),
					scan.nextDouble());
			
			inventory[i] = item;
		}
		
		int totalCustomers = scan.nextInt();
		
		Customer[] customers = new Customer[totalCustomers];
		
		for (int i = 0; i < customers.length; i++) {
			Customer customer = new Customer(scan.next() + " ",
					scan.next() + " (",
					scan.nextInt());
			
			customers[i] = customer;
			customers[i].shoppingCart = new Item[customer.totalItems];
			
			for (int j = 0; j < customer.totalItems; j++) {
				Item product = new Item(scan.nextInt(),
						scan.next(),
						0.0);
				
				findPrice(inventory, product);
				
				customers[i].shoppingCart[j] = product;
			}
			
		}
		
		scan.close();
		
		cashRegister(customers);
		
		Customer biggest = findBiggest(customers);
		String biggestValue = String.format("%.2f", biggest.totalSpent) + ")";
		
		Customer smallest = findSmallest(customers);
		String smallestValue = String.format("%.2f", smallest.totalSpent) + ")";
		
		double average = findAvg(customers);
		String avgToString = String.format("%.2f", average);
		
		System.out.println("Biggest: " + biggest.firstName + biggest.lastName + biggestValue);
		System.out.println("Smallest: " + smallest.firstName + smallest.lastName + smallestValue);
		System.out.println("Average: " + avgToString);
		
	}
	
	static void findPrice (Item[] inventory, Item item) {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i].name.contentEquals(item.name)) {
				item.cost = inventory[i].cost;
			}
		}
	}
	
	static void cashRegister (Customer[] customers) {
		for (int i = 0; i < customers.length; i++) {
			double total = 0.0;
			
			for (int j = 0; j < customers[i].shoppingCart.length; j++) {
				total += (customers[i].shoppingCart[j].amount * customers[i].shoppingCart[j].cost);
			}
			
			customers[i].totalSpent = total;
		}
	}
	
	static Customer findBiggest (Customer[] customers) {
		Customer currentBiggest = customers[0];
		
		for (int i = 1; i < customers.length; i++) {
			if (customers[i].totalSpent >= currentBiggest.totalSpent) {
				currentBiggest = customers[i];
			}
		}
		
		return currentBiggest;
	}
		
	static Customer findSmallest (Customer[] customers) {
		Customer currentSmallest = customers[0];
		
		for (int i = 0; i < customers.length; i++) {
			if (customers[i].totalSpent <= currentSmallest.totalSpent) {
				currentSmallest = customers[i];
			}
		}
		
		return currentSmallest;
	}
	
	static double findAvg (Customer[] customers) {
		double sum = 0.0;
		
		for (int i = 0; i < customers.length; i++) {
			sum += customers[i].totalSpent;
		}
		
		return sum / (customers.length);
	}
	
}
