package com.alphaShoppee.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alphaShoppee.genericUtility.WebdriverUtility;

public class AdminSubcategoryPage {

//	driver.findElement(By.xpath("//a[.='Sub Category ']/..")).click();
//	wUtil.selectDropdownByIndexOrVisibleText(driver.findElement(By.name("category")), eUtil.getStringDataFromExcel(sheetName, 6, 1));
//	driver.findElement(By.xpath("//input[@placeholder='Enter SubCategory Name']")).sendKeys(eUtil.getStringDataFromExcel(sheetName, 8, 1));
//	driver.findElement(By.name("submit")).click();
	
	//Declaration
	
	@FindBy(name = "category")
	private WebElement categorySelect;
	
	@FindBy(xpath = "//input[@placeholder='Enter SubCategory Name']")
	private WebElement subcategoryTextfield;
	
	@FindBy(name = "submit")	
	private WebElement submitButton;
	
	
	//Initialization
	
	public AdminSubcategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	
	//Utilization
	
	
	public WebElement getCategorySelect() {
		return categorySelect;
	}

	public WebElement getSubcategoryTextfield() {
		return subcategoryTextfield;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	
	
	
	//Business libraries
	
	public void createASubcategory(WebdriverUtility wUtil, String categoryVisibleText, String subcategoryName) {
		wUtil.selectDropdownByIndexOrVisibleText(categorySelect, categoryVisibleText);
		subcategoryTextfield.sendKeys(subcategoryName);
		submitButton.click();
	}
	
	
}
