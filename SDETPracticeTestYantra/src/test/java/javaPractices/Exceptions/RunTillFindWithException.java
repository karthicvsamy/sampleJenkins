package javaPractices.Exceptions;

import java.util.Scanner;

public class RunTillFindWithException {

	public static void main(String[] args) {
		tryAgain();
	}
	public static void tryAgain() {
		Scanner nsn = new Scanner(System.in);
		System.out.println("Enter the name");
		String inputString = nsn.nextLine();
		try {
			if(inputString.equals("tom")){
				System.out.println("This is matching");
			}
			else {
				throw new NameNotFoundException();
			}
		}
		catch (NameNotFoundException nnf) {
			System.out.println("Name is mismatching and exception is handled, try again");
			tryAgain();
		}
}
}
