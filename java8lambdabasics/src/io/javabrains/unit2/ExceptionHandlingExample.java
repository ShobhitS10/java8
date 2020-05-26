package io.javabrains.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {
	public static void main(String[] args) {
		int [] someNumbers = {1,2,3,4};
		int key1 = 2;
		int key2 = 0;
		
		process(someNumbers, key1, wrapperLambda((v,k) -> System.out.println(v / k)));
		process(someNumbers, key2, wrapperLambda((v,k) -> System.out.println(v / k)));
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for(int i : someNumbers) {
			/* One way to handle exception
			try {
				consumer.accept(i, key);
			}
			catch (ArithmeticException e) {
				// _____
			}
			*/
			consumer.accept(i, key);
			
		}
	}
	
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (v,k) -> {
			try {
				consumer.accept(v, k);
			}
			catch(ArithmeticException e) {
				System.out.println("Exception caught");
			}
		};
	}

}
