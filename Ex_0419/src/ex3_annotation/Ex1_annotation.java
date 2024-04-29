package ex3_annotation;

@FunctionalInterface
interface f {
	public void iAdd();
}

class Parent {
	public void info() {
		
	}
}

class Child extends Parent {
	@Override
	public void info() {
		
	}
}

@SuppressWarnings("unused")
public class Ex1_annotation {
	public static void main(String[] args) {
		
		add();
		int num = 10;
	}
	
	@Deprecated
	public static void add() {
		System.out.println("hi");
	}
}
