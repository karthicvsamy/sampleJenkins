package com.alphaShoppee.elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[.='Login']/..")
	private WebElement loginTab;
	
	@FindBy(xpath = "//a[contains(.,'Welcome')]")
	private WebElement welcomeText;
	
	@FindBy(name = "product")
	private WebElement searchBox;
	
	
	
	public UserHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickRequiredProduct(String product) {
		driver.findElement(By.xpath("//a[.='"+product+"']/ancestor::div[@class='product']//div[@class='image'][1]")).click();
	}
	
	public WebElement getLoginTab() {
		return loginTab;
	}

	public WebElement getWelcomeText() {
		return welcomeText;
	}
	
	public WebElement getSearchBox() {
		return searchBox;
	}
	
}
