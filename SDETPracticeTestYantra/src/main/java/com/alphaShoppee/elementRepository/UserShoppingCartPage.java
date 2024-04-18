package com.alphaShoppee.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserShoppingCartPage {

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody//tr[last()]/td[3]")
	private WebElement tableLastRowThirdColumn;
	
	
	public UserShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getTableLastRowThirdColumn() {
		return tableLastRowThirdColumn;
	}
	
	
}
