package com.alphaShoppee.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminLoginPage {
	

	//Declaration
	
	@FindBy(name = "username")
	private WebElement usernameTextfield;
	
	@FindBy(name = "password")
	private WebElement passwordTextfield;
	
	@FindBy(name = "submit")
	private WebElement submitButton;
	

	
	//Initialization
	
	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	
	public WebElement getUsernameTextfield() {
		return usernameTextfield;
	}
	
	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	//Business libraries
	
	public void adminLogin(String username, String password) {
		usernameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		submitButton.click();
	}
	
//	
	@Test(dataProvider = "provideData")
	public void adminLoginDataProvider(String obj1, String obj2){
//		adminLogin(obj1, obj2);
		System.out.println(obj1);
		System.out.println(obj2);
	}
	
}
