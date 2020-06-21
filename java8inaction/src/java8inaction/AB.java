package java8inaction;

public class AB implements A, B {
	@Override
	public void play() {
		System.out.println(this.getClass());
	}

	@Override
	public void setGame() {
		// A.super.setGame();
	}

	public static void main(String[] args) {
		A a = new AB();
		B b = new AB();
		
		a.play();
		b.play();
	}
}
