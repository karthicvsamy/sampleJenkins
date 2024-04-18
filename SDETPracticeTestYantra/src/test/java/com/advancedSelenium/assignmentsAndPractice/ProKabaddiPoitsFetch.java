package com.advancedSelenium.assignmentsAndPractice;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabaddiPoitsFetch {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.prokabaddi.com/standings");
		
		driver.findElement(By.xpath("//div[@class='row-head' and contains(.,'Puneri Paltan')]/div[contains(@class,'play')]"));
		
		ArrayList< String> keys = new ArrayList<String>();
		keys.add("matches-play");
		keys.add("matches-won");
		keys.add("matches-lost");
		keys.add("matches-draw");
		keys.add("score-diff");
		keys.add("form");
		keys.add("points");
		
		String name = "Dabang Delhi K.C.";

		for(String key: keys) {
			String value = driver.findElement(By.xpath("//div[@class='row-head' and contains(.,'"+name+"')]/div[contains(@class,'"+key+"')]")).getText();
			System.out.println(key+" :- "+value);
		}
		
	}
}
