package com.alphaShoppee.elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserWishlistPage {
	
	WebDriver driver;

	@FindBy(xpath = "//table/tbody//h4/a")
	private WebElement tableProductElement;
	
	@FindBy(xpath = "//table/tbody//a[contains(@onclick,'return')]")
	private WebElement removeButton;
	
	
	
	public UserWishlistPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	

	public WebElement getTableProductElement() {
		return tableProductElement;
	}
	
	public WebElement getRemoveButton() {
		return removeButton;
	}


	public boolean checkProduct(String productName) {
		return tableProductElement.getText().equalsIgnoreCase(productName);
	}
	
	public WebElement checkProductIsThere(String productName) {
		return driver.findElement(By.xpath("//a[.='"+productName+"']"));
	}
	
}
