package a1;

import java.util.Scanner;

public class A1Jedi {

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
				
				toInventory(product, inventory);
				
				customers[i].shoppingCart[j] = product;
			}
			
			countCustomers (customers[i].shoppingCart, inventory);
			
		}
		
		scan.close();
		
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i].totalOrders == 0) {
				System.out.println("No customers bought " + inventory[i].name);
			} else {
				int totalOrders = inventory[i].totalOrders;
				int amount = inventory[i].amount;
				
				
				System.out.println(totalOrders + " customers bought " + amount + " " + inventory[i].name);
			}
		}
	}
	
	// helper functions
	
	static void toInventory (Item item, Item[] inventory) {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i].name.contentEquals(item.name)) {
				inventory[i].amount += item.amount;
			}
		}
	}
	
	static boolean notSeenBefore (Item item, Item[] shoppingCart, int index) {
		for (int i = 0; i < index; i++) {
			if (shoppingCart[i].name.contentEquals(item.name)) {
				return false;
			}
		}
		return true;
	}
	
	static void countCustomers (Item[] shoppingCart, Item[] inventory) {
		for (int i = 0; i < shoppingCart.length; i++) {
			if (notSeenBefore(shoppingCart[i], shoppingCart, i)) {
				for (int j = 0; j < inventory.length; j++) {
					if (inventory[j].name.contentEquals(shoppingCart[i].name)) {
						inventory[j].totalOrders += 1;
					}
				}
			}
		}
	}
}
