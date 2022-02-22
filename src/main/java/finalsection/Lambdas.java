package finalsection;

import java.util.function.Function;

public class Lambdas {
	
	Integer number = null;

	public static void main(String[] args) {
		Function<String, String> uppercaseName = name -> name.toUpperCase();
		System.out.println(uppercaseName.apply("john"));
	}
}
