package streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class _Stream {
	
	public static void main(String[] args) {
		
		List<Person> people = List.of(
			new Person("John", Gender.MALE),
			new Person("Maria", Gender.FEMALE),
			new Person("Aisha", Gender.FEMALE),
			new Person("Alex", Gender.MALE),
			new Person("Alice", Gender.FEMALE)
		);
		
		Function<Person, String> personNameFunction = person -> person.name;
		ToIntFunction<String> lengthFunction = String::length;
		IntConsumer printlnFunction = System.out::println;
		
		people.stream()
			.map(personNameFunction)
			.mapToInt(lengthFunction)
			.forEach(printlnFunction);
		
		Predicate<Person> predicate = person -> person.gender.equals(Gender.FEMALE);
		boolean females = people.stream()
			.allMatch(predicate);
		System.out.println(females);
	}
	
	static class Person {
		private final String name;
		private final Gender gender;
		
		public Person(String name, Gender gender) {
			this.name = name;
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + "]";
		}
	}
	
	enum Gender {
		MALE, FEMALE
	}

}
