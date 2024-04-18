package javaPractices.Exceptions;

public class RuntimeExceptionRunner {

	public static void main(String[] args) {
		System.out.println("My custom runtime exception is going to execute");
		throw new MyCustomRuntimeException();
	}
}
