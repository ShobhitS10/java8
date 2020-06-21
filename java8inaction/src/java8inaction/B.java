package java8inaction;

public interface B {
	void play();
	
	default void setGame() {
		System.out.println("This is game A");
	}
}
