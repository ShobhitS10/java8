package io.javabrains.unit2;

public class ThisReferenceExample {
	public void doProcess(int i, Process p) {
		p.process(i);
	}
	
	public void execute() {
		doProcess(10, i -> {
			System.out.println("Value of i is " + i);
			System.out.println(this);
		});
	}
	
	public static void main(String[] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		// this works here
		/*
		thisReferenceExample.doProcess(10, new Process() {
			@Override
			public void process(int i) {
				System.out.println("Value of i is " + i);
				System.out.println(this);
			}
		});
		*/
		
		/*
		// this does not works here
		thisReferenceExample.doProcess(10, i -> {
			System.out.println("Value of i is " + i);
			// System.out.println(this); this will not work
		});
		*/
		
		thisReferenceExample.execute();
		
	}
	
	interface Process {
		void process(int i);
	}
}
