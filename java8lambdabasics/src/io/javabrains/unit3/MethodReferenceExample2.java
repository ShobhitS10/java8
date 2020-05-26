package io.javabrains.unit3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.javabrains.unit2.Person;

public class MethodReferenceExample2 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Shobhit","Sachdeva",31),
				new Person("Charu","Vashisht",31),
				new Person("Virendra","Singh",34),
				new Person("Vanshika","Tuteja",28),
				new Person("Anuj","Batra",31),
				new Person("Ruchi","Chopra",31)
		);
		
		System.out.println("Printing all persons");
		performConditionally(people, p -> true, System.out::println); // p -> method(p)
	}
	
	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person p : people) {
			if(predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}

}
