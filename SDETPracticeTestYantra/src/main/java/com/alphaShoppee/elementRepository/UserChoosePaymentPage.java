package com.alphaShoppee.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserChoosePaymentPage {

	@FindBy(xpath = "//input[@value='Internet Banking']")
	private WebElement internetRadioButton;
	
	@FindBy(name = "submit")
	private WebElement submitButton;
	
	
	
	public UserChoosePaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebElement getInternetRadioButton() {
		return internetRadioButton;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	
}
