package com.alphaShoppee.elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProductPage {
	
	WebDriver driver;

	@FindBy(xpath = "//a[.='Add to cart']")
	private WebElement addtocartButton;
	
	@FindBy(xpath = "//div[contains(@class,'favorite-button')]/a")
	private WebElement wishlistButton;
	
	
	public UserProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}


	public WebElement getAddtocartButton() {
		return addtocartButton;
	}

	public WebElement getWishlistButton() {
		return wishlistButton;
	}
	
	public boolean wishlistConfirmation(String productName) {
		return driver.findElement(By.xpath("//a[.='"+productName+"']")).isDisplayed();
	}
	
	
	
}
