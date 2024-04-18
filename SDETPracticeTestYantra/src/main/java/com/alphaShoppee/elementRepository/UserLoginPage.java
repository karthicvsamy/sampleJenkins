package com.alphaShoppee.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	
	@FindBy(name = "email")
	private WebElement emailTextfield;
	
	@FindBy(name = "password")
	private WebElement passwordTextfield;
	
	@FindBy(name = "login")
	private WebElement loginButton;
	
	
	public UserLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginToUser(String username, String password) {
		emailTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		loginButton.click();
	}
	

}
