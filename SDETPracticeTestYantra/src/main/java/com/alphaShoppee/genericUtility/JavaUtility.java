package com.alphaShoppee.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber(int maxNum) {
		
		Random random = new Random();
		int randomNumber = random.nextInt(maxNum);
		return randomNumber;
		
	}
	
	public String getSystemDate() {
		Date date = new Date();
		return date.toString();
	}
	
	
	public String getSystemDateInFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd KK-mm-ss");
		Date date = new Date();
		return sdf.format(date);
	}
	
	
}


