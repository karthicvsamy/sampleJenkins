package javaPractices.Exceptions;

import java.util.Scanner;

public class NameExceptionRunner {

	public static void main(String[] args) {
		Scanner nsn = new Scanner(System.in);
		System.out.println("Enter the name");
		String inputString = nsn.nextLine();
		String[] stringArray = {"tom","jerry","timon","bumba"};
		int count = 0;
		for(int i=0;i<stringArray.length;i++) {
			if(inputString.equals(stringArray[i]))
				count++;
		}
		if (count==0)
			throw new NameNotFoundException();
		throw new NameFoundException();
	}
}
