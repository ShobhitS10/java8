package java8inaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TestStreams {

	public static void main(String[] args) {
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
		new Transaction(brian, 2011, 300),
		new Transaction(raoul, 2012, 1000),
		new Transaction(raoul, 2011, 400),
		new Transaction(mario, 2012, 710),
		new Transaction(mario, 2012, 700),
		new Transaction(alan, 2012, 950)
		);
		
//		1. Find all transactions in the year 2011 and sort them by value (small to high).
		System.out.println("\n1. Find all transactions in the year 2011 and sort them by value (small to high).");
		
		// List<Transaction> transactions2011sorted = 
				transactions.stream()
				.filter((Transaction t) -> t.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue))
		// OR	.sorted((t1,t2) -> ((Integer)t1.getValue()).compareTo((Integer)t2.getValue()))
		//		.collect(Collectors.toList())
				.forEach(System.out::println);
		
//		2. What are all the unique cities where the traders work?
		System.out.println("\n2. What are all the unique cities where the traders work?");
		
				List<Trader> traders = Arrays.asList(raoul,mario,alan,brian);
				traders.stream()
				.map(Trader::getCity)
				.distinct()
				.forEach(System.out::println);
						
//		3. Find all traders from Cambridge and sort them by name.
		System.out.println("\n3. Find all traders from Cambridge and sort them by name.");
				
				traders.stream()
				.filter((Trader t) -> t.getCity() == "Cambridge")
				.sorted(Comparator.comparing(Trader::getName))
				.distinct()
				.forEach(System.out::println);
				
//		4. Return a string of all traders’ names sorted alphabetically.
		System.out.println("\n4. Return a string of all traders’ names sorted alphabetically.");
		
				System.out.println(traders.stream()
						.map(Trader::getName)
						.sorted()
						.reduce("",(n1,n2) -> n1+n2));
				
//		5. Are any traders based in Milan?
		System.out.println("\n5. Are any traders based in Milan?");
				
				traders.stream()
				.filter(t -> t.getCity() == "Milan")
				.findAny()
				.ifPresent(t -> System.out.println(t.getName()));
				
//		6. Print all transactions’ values from the traders living in Cambridge.
		System.out.println("\n6. Print all transactions’ values from the traders living in Cambridge.");		
				
				transactions.stream()
				.filter((Transaction t) -> t.getTrader().getCity() == "Cambridge")
				.distinct()
				.forEach(System.out::println);
				
//		7. What’s the highest value of all the transactions?
		System.out.println("\n7. What’s the highest value of all the transactions?");
		
			transactions.stream()
			.map((Transaction t) -> t.getValue())
			.reduce(Integer::max)
			.ifPresent(System.out::println);
				
//		8. Find the transaction with the smallest value.
		System.out.println("\n8. Find the transaction with the smallest value.");
		
			transactions.stream()
			.min(Comparator.comparing(Transaction::getValue))
			.ifPresent(System.out::println);
			// OR
			transactions.stream().reduce((t1,t2) -> t1.getValue() < t2.getValue() ? t1 : t2).ifPresent(System.out::println);
			
			transactions.stream().map(Transaction::getValue).reduce(Integer::max).ifPresent(System.out::println);
			
			Map<Integer,List<Transaction>> yearTransaction = transactions.stream().collect(Collectors.groupingBy(Transaction::getYear));
			System.out.println(yearTransaction);
	}

}
