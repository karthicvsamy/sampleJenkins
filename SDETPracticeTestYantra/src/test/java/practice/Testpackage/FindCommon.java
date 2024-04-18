package practice.Testpackage;

import java.io.IOException;

public class FindCommon {

	public static void main(String[] args) throws IOException {

		String str[] = {"hello","aheolld","helloop","oh"};
		String result =  "";
		int stringCount = str.length;

		String small = str[0];
		for(int k=0;k<stringCount;k++) {
			if(small.length()>str[k].length()) {
				small = str[k];
			}
		}
		int commonLength = small.length();
		
		
		String common = str[0];
		for(int i=1;i<stringCount;i++) {
			for(int j=0;j<common.length();j++) {
				for(int k=0;k<str[i].length();k++) {
					if(common.charAt(j) == str[i].charAt(k)) {
						result = result + common.charAt(j);
						break;
					}
				}
			}
			common = result;
			result = "";
			System.out.println(common);
		}

//		if(result.length()>0) {
//			System.out.println(result);
//		}
//		else {
//			System.out.println(-1);
//		}
	}
}
