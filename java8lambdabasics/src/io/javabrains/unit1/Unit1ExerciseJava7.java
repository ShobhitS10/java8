package io.javabrains.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseJava7 {

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
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		
		System.out.println("Printing sorted list");
		// Step 2: Create a method that prints all elements in the list
		printAll(people);
		
		// Step 3: Create a method that prints all people that have last name beginning with S
		System.out.println("\nPrinting using single hardcoded condition");
		printFilteredList(people);
		// OR
		System.out.println("\nPrinting by providing multiple condition");
		printConditionally(people, new Condition() {
		@Override
		public boolean test(Person p) {
			if(p.getLastName().startsWith("S")) return true;
			return false;
		}
		});
		
	}

	private static void printAll(List<Person> people) {
		for(Person p : people) {
			System.out.println(p.toString());
		}
	}
	
	public static void printFilteredList(List<Person> people) {
		for(Person p : people) {
			if(p.getLastName().startsWith("S")) {
				System.out.println(p.toString());
			}
		}
	}
	
	private static void printConditionally(List<Person> people, Condition condition) {
		for(Person p : people) {
			if(condition.test(p)) {
				System.out.println(p.toString());
			}
		}
	}

}
