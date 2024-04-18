package com.alphaShoppee.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alphaShoppee.genericUtility.WebdriverUtility;

public class AdminProductStatusPage {

	WebDriver driver;
	
	@FindBy(name = "status")
	private WebElement statusSelect;
	
	@FindBy(name = "remark")
	private WebElement remarkTextfield;
	
	@FindBy(name = "submit2")
	private WebElement submitButton;
	
	public AdminProductStatusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	WebdriverUtility wUtil = new WebdriverUtility(driver);
			
	public void changeToDelivered(String selectName, String remarks) {
		wUtil.selectDropdownByIndexOrVisibleText(statusSelect, selectName);
		remarkTextfield.sendKeys(remarks);
		submitButton.click();
	}
	
}
