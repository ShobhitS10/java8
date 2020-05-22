package io.javabrains.unit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

// Here in this example we are using the Predicate interface from java.util.function package instead of creating our own interface
public class Unit1ExerciseJava8 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Shobhit","Sachdeva",31),
				new Person("Charu","Vashisht",31),
				new Person("Virendra","Singh",34),
				new Person("Vanshika","Tuteja",28),
				new Person("Anuj","Batra",31),
				new Person("Ruchi","Chopra",31)
		);
		
		// Step 1: Sort list by last name
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		System.out.println("Printing sorted list");
		// Step 2: Create a method that prints all elements in the list	
		printConditionally(people, p -> true);
		
		System.out.println("Printing list of people with last name beginning with S");
		// Step 3: Create a method that prints all people that have last name beginning with S
		printConditionally(people, p -> p.getLastName().startsWith("S"));
	}
	
	private static void printConditionally(List<Person> people, Predicate<Person> condition) {
		for(Person p : people) {
			if(condition.test(p)) {
				System.out.println(p.toString());
			}
		}
	}

}
