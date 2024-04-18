package com.advancedSelenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectorshubSenddataShadowRoot {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		SearchContext shadowOne = driver.findElement(By.cssSelector("#userName")).getShadowRoot();
		shadowOne.findElement(By.cssSelector("#kils")).sendKeys("Successful");
		
		SearchContext shadowTwo = shadowOne.findElement(By.cssSelector("#app2")).getShadowRoot();
		shadowTwo.findElement(By.cssSelector("#pizza")).sendKeys("Again successful");
	}
}
