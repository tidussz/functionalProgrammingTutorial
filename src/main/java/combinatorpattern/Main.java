package combinatorpattern;

import java.time.LocalDate;
import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

	public static void main(String[] args) {
		Customer customer = new Customer("Alice", "alice@gmail.com", "+089465452", LocalDate.of(2000, 1, 18));
		Customer customer2 = new Customer("John", "johngmail.com", "089465452", LocalDate.of(2015, 1, 18));

		// if valid, we can store customer in db
		System.out.println(new CustomerValidatorService().isValid(customer));
		System.out.println(new CustomerValidatorService().isValid(customer2));

		// Using combinator pattern
		ValidationResult result = isEmailValid().and(isPhoneNumberValid()).and(isAnAdult()).apply(customer);
		ValidationResult result2 = isEmailValid().and(isPhoneNumberValid()).and(isAnAdult()).apply(customer2);
		System.out.println(result);
		System.out.println(result2);
		
		if (result != ValidationResult.SUCCESS) {
			throw new IllegalStateException(result.name());
		}
		
		if (result2 != ValidationResult.SUCCESS) {
			throw new IllegalStateException(result2.name());
		}
	}
}
