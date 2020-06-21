package java8inaction;

public interface A {
	void play();
	
	default void setGame() {
		System.out.println("This is game A");
	}
}
