package io.javabrains.unit3;

import java.util.Arrays;
import java.util.List;

import io.javabrains.unit2.Person;

public class StreamsExample1 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Shobhit","Sachdeva",31),
				new Person("Charu","Vashisht",31),
				new Person("Virendra","Singh",34),
				new Person("Vanshika","Tuteja",28),
				new Person("Anuj","Batra",31),
				new Person("Ruchi","Chopra",31)
		);
		
		people.stream()
		.filter(p -> p.getLastName().startsWith("S"))
		.forEach(p -> System.out.println(p.getFirstName()));
		
	}

}
