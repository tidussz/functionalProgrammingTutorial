package finalsection;

import java.util.function.Consumer;

public class Callbacks {

	public static void main(String[] args) {
		
		Consumer<String> callback = value -> {
			System.out.println("No last name provided for " + value);
		};
		
		hello("John", "Montana", callback);
		hello("John", null, callback);
		
		hello("Maria", null, () -> {
			System.out.println("No last name provided");
		});
	}
	
	static void hello(String firstName, String lastName, Consumer<String> callback) {
		System.out.println(firstName);
		if (lastName != null) {
			System.out.println(lastName);
		}
		else {
			callback.accept(firstName);
		}
	}
	
	static void hello(String firstName, String lastName, Runnable callback) {
		System.out.println(firstName);
		if (lastName != null) {
			System.out.println(lastName);
		}
		else {
			callback.run();
		}
	}
}
