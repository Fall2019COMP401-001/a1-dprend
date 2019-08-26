package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int total = scan.nextInt();
		
		Customer[] customers = new Customer[total];
		double[] price = new double[total];
		
		
		for (int i = 0; i < customers.length; i++) {
			Customer customer = new Customer(scan.next().charAt(0) + ". ",
													scan.next() + ": ",
													scan.nextInt());
			
			customers[i] = customer;
			
			Item[] items = new Item[customers[i].totalItems];
			
			for (int j = 0; j < customers[i].totalItems ; j++) {
				
				Item item = new Item(scan.nextInt(),
											scan.next(),
											scan.nextDouble());
				
				items[j] = item;
				
			}
			
			price[i] = calculatePrice(items);
			
		}
		
		scan.close();
		
		for (int i = 0; i < customers.length; i++) {
            String toString = String.format("%.2f" , price[i]);
			
			System.out.println(customers[i].firstName + customers[i].lastName +  toString);
		}
		
	}
	
	public static double calculatePrice (Item[] items) {
		double price = 0.0;
		
		for (int i = 0; i < items.length; i++) {
			price += (items[i].amount * items[i].cost);
		}
		
		return price;
	}
	 
}
