package a1;

public class Customer {
	
	String firstName;
	String lastName;
	int totalItems;
	Item[] shoppingCart;
	double totalSpent; 
	
	//constructor
	public Customer (String firstName, String lastName, int totalItems) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalItems = totalItems;
	}
}