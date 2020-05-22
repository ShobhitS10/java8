package io.javabrains.unit1;

public class TypeInferenceExample {

	public static void main(String[] args) {
		StringLengthLambda myLambda = s -> s.length();
		// The lambda expression is basically the implementation of the abstract function
		// it is not the execution
		// but, to execute the lambda function, the interface abstract method must be called.
		System.out.println(myLambda.getLength("Hello"));
		
		// OR
		
		printLambda(s -> s.length());
	}
	
	public static void printLambda(StringLengthLambda s) {
		System.out.println(s.getLength("Hello"));
	}

	interface StringLengthLambda {
		int getLength(String s);
	}
}
