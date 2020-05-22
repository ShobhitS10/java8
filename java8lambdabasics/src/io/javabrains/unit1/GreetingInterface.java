package io.javabrains.unit1;

@FunctionalInterface
public interface GreetingInterface {
	public void perform();
	// compilation error, cannot add another abstract method to a functional interface
	// public void xyz(int a);
}
