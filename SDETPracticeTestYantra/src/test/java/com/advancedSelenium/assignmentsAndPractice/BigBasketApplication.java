package com.advancedSelenium.assignmentsAndPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasketApplication {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.bigbasket.com/");
		driver.findElement(By.xpath("//header[@style='opacity: 1;']//input")).sendKeys("apple"+Keys.ENTER);
		
		WebElement addButton = driver.findElement(By.xpath("//div[@class='SKUDeck___StyledDiv-sc-1e5d9gk-0 eA-dmzP' and contains(.,'Apple - Royal Gala Economy')]//button[.='Add']"));
		Actions action = new Actions(driver);
		action.scrollToElement(addButton).build().perform();
		action.click(addButton).perform();
		WebElement addSymbol = driver.findElement(By.xpath("//div[@class='SKUDeck___StyledDiv-sc-1e5d9gk-0 eA-dmzP' and contains(.,'Apple - Royal Gala Economy')]//*[name()='svg' and contains(@class,'CtaOnDeck___StyledPlusIcon-sc-orwifk-12 kyqQMg')]"));
			
		for(int i=0;i<2;i++) {
			action.click(addSymbol).click(addSymbol).build().perform();
		}
		String numberText = driver.findElement(By.xpath("//div[@class='SKUDeck___StyledDiv-sc-1e5d9gk-0 eA-dmzP' and contains(.,'Apple - Royal Gala Economy')]//span[@class='Label-sc-15v1nk5-0 CtaOnDeck___StyledLabel-sc-orwifk-11 gJxZPQ ezEGzY']")).getText();
		System.out.println(numberText);
		int num = Integer.parseInt(numberText);
		
		System.out.println(num);
		
	}
}
