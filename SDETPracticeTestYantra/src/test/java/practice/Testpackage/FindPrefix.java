package practice.Testpackage;

import java.io.IOException;

public class FindPrefix {

	public static void main(String[] args) throws IOException {

		String str[] = {"hello","ahelld","helloop","hel"};
		String result =  "";
		int stringCount = str.length;

		String small = str[0];
		for(int k=0;k<stringCount;k++) {
			if(small.length()>str[k].length()) {
				small = str[k];
			}
		}
		int commonLength = small.length();

		for(int i=0;i<commonLength;i++) {
			int count = 0;
			for(int j=1; j<stringCount; j++) {
				if((str[0].charAt(i) == str[j].charAt(i))) {
					count++;
				}
			}
			if(count == stringCount -1) {
				result = result + str[0].charAt(i);
			}
			else {
				break;
			}
		}

		if(result.length()>0) {
			System.out.println(result);
		}
		else {
			System.out.println(-1);
		}
	}
}
