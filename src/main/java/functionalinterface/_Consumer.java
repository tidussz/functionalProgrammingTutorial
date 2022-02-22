package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
	
	public static void main(String[] args) {
		
		Customer maria = new Customer("Maria", "99999");
		
		// Normal Java function
		greetCustomer(maria);
		greetCustomerV2(maria, false);
		
		// Consumer Functional interface
		greetCustomerConsumer.accept(maria);
		greetCustomerConsumerV2.accept(maria, false);
	}
	
	static Consumer<Customer> greetCustomerConsumer = customer -> 
		System.out.println("Hello " + customer.name + 
			", thanks for registering phone number " 
			+ customer.phoneNumber);
		
		
	static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> 
		System.out.println("Hello " + customer.name + 
			", thanks for registering phone number " 
			+ (showPhoneNumber ? customer.phoneNumber : "****"));
	
	static void greetCustomer(Customer customer) {
		System.out.println("Hello " + customer.name + 
				", thanks for registering phone number " 
				+ customer.phoneNumber);
	}
	
	static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
		System.out.println("Hello " + customer.name + 
				", thanks for registering phone number " 
				+ (showPhoneNumber ? customer.phoneNumber : "****"));
	}
	
	static class Customer {
		private final String name;
		private final String phoneNumber;
		
		public Customer(String name, String phoneNumber) {
			super();
			this.name = name;
			this.phoneNumber = phoneNumber;
		}
	}
}
