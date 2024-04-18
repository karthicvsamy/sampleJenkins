package com.alphaShoppee.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alphaShoppee.genericUtility.WebdriverUtility;

public class AdminManageProductsPage {

	private WebDriver driver;
	
	//Declaration
	
	@FindBy(xpath = "//label[.='Search: ']/input")
	private WebElement searchTextfield;
	
	@FindBy(xpath = "//table[@id='DataTables_Table_0']/tbody/tr/td[2]")
	private WebElement tableSecondColumn;
	
	@FindBy(xpath = "//table[@id='DataTables_Table_0']/tbody/tr[1]/td//i[@class='icon-edit']")
	private WebElement firstEditIcon;
	
	@FindBy(name = "productAvailability")
	private WebElement availabilitySelect;
	
	@FindBy(xpath = "//strong[.='Well done!']")
	private WebElement welldoneText;
	
	@FindBy(name = "submit")
	private WebElement submitButton;
	
	//Initialization
	
	public AdminManageProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	//Utilization
	
	public WebElement getSearchTextfield() {
		return searchTextfield;
	}
	
	public WebElement getTableSecondColumn() {
		return tableSecondColumn;
	}
	
	public WebElement getFirstEditIcon() {
		return firstEditIcon;
	}
	
	public WebElement getAvailabilitySelect() {
		return availabilitySelect;
	}

	public WebElement getWelldoneText() {
		return welldoneText;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	
	//Business library
	
	WebdriverUtility wUtil = new WebdriverUtility(driver);
	public void changeAvailability(String visibleText) {
		wUtil.selectDropdownByIndexOrVisibleText(availabilitySelect, visibleText);
	}
	
	
}
