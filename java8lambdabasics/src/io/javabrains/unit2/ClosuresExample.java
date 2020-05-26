package io.javabrains.unit2;

public class ClosuresExample {

	public static void main(String[] args) {
		int a= 10;
		int b= 20;
		/*
		doProcess(a,new Process() {
			@Override
			public void process(int i) {
				//  Not allowed "b = 40;"
				// Compiler assumes that we know b is final
				System.out.println(i + b);
			}
		});
		*/
		// b value gets frozen to 20, wherever the lambda expression goes, the value of b goes with it unchanged
		// compiler expects it to be effectively final
		doProcess(a,i -> System.out.println(i+b));
	}
	
	public static void doProcess(int i, Process p) {
		p.process(i);
	}
	
	interface Process {
		void process(int i);
	}

}
