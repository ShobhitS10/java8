package io.javabrains.unit1;

public class Greeter {

	// 1. Always printing Hello World!
	public void greet() {
		System.out.println("Hello World Basic!");
	}
	
	// 2. Having behavior itself being passed as an argument (Java 7)
	public void greet(GreetingInterface greeting) {
		greeting.perform();
	}
	
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		// 1. Very basic
		greeter.greet();
		
		// 2. Java 7
		HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
		helloWorldGreeting.perform();
		
		// OR
		GreetingInterface anonymousClassGreeting = new GreetingInterface() {
			@Override
			public void perform() {
				System.out.println("Hello World Anonymous!");
			}
		};
		anonymousClassGreeting.perform();
		
		// 3. Using Lambda expression
		GreetingInterface myLambdaGreeting = () -> System.out.println("Hello World Java 8 (Lambda)!");
		myLambdaGreeting.perform();
		// or
		greeter.greet(myLambdaGreeting);
	}

}
