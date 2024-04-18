package com.alphaShoppee.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminCategoryPage {
	
//	driver.findElement(By.xpath("//a[.=' Create Category ']/..")).click();
//	driver.findElement(By.name("category")).sendKeys(eUtil.getStringDataFromExcel(sheetName, 6, 1));
//	driver.findElement(By.name("description")).sendKeys(eUtil.getStringDataFromExcel(sheetName, 7, 1));
//	driver.findElement(By.name("submit")).click();
	
	//Declaration
	
	@FindBy(xpath = "//a[.=' Create Category ']/..")
	private WebElement createCategoryTab;
	
	@FindBy(xpath = "//a[.='Sub Category ']/..")
	private WebElement subcategoryTab;
	
	@FindBy(xpath = "//a[.='Insert Product ']/..")
	private WebElement insertProductTab;
	
	@FindBy(xpath = "//a[.='Manage Products ']/..")
	private WebElement manageProductsTab;
	
	@FindBy(name = "category")
	private WebElement categoryTextfield;
	
	@FindBy(name = "description")
	private WebElement descriptionTextfield;
	
	@FindBy(name = "submit")
	private WebElement submitButton;
	
	
	
	
	
	
	
	//Initialization
	
	public AdminCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	

	//Declaration
	
	public WebElement getCreateCategoryTab() {
		return createCategoryTab;
	}
	
	public WebElement getSubcategoryTab() {
		return subcategoryTab;
	}
	
	public WebElement getInsertProductTab() {
		return insertProductTab;
	}

	public WebElement getManageProductsTab() {
		return manageProductsTab;
	}
	
	public WebElement getCategoryTextfield() {
		return categoryTextfield;
	}

	public WebElement getDescriptionTextfield() {
		return descriptionTextfield;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	
	//Business libraries
	
	public void createACategory(String categoryName, String description) {
		categoryTextfield.sendKeys(categoryName);
		descriptionTextfield.sendKeys(description);
		submitButton.click();
	}
	
}
