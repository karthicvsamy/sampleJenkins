package javaPractices.Exceptions;

public class CompiletimeExceptionRunner {

	public static void main(String[] args) throws MyCustomCompiletimeException {
		 System.out.println("custom compile time exception is going to execute");
		throw new MyCustomCompiletimeException();
	}
}
