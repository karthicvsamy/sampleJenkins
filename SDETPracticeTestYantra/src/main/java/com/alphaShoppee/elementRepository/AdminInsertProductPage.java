package com.alphaShoppee.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alphaShoppee.genericUtility.WebdriverUtility;

public class AdminInsertProductPage {

	WebDriver driver;

	
	//Declaration
	
	@FindBy(name = "category")
	private WebElement categorySelect;
	
	@FindBy(name = "subcategory")
	private WebElement subcategorySelect;
	
	@FindBy(name = "productName")
	private WebElement nameTextfield;
	
	@FindBy(name = "productCompany")
	private WebElement companyTextfield;
	
	@FindBy(name = "productpricebd")
	private WebElement priceBeforeDiscoutTextfield;
	
	@FindBy(name = "productprice")
	private WebElement priceAfterDiscoutTextfield;
	
	@FindBy(name = "productDescription")
	private WebElement descriptionTextfield;
	
	@FindBy(name = "productShippingcharge")
	private WebElement shippingchargeTextfield;
	
	@FindBy(name = "productAvailability")
	private WebElement availabilitySelect;
	
	@FindBy(name = "productimage1")
	private WebElement imageOneUploadButton;
	
	@FindBy(name = "productimage2")
	private WebElement imageTwoUploadButton;
	
	@FindBy(name = "productimage3")
	private WebElement imageThreeUploadButton;
	
	@FindBy(name = "submit")
	private WebElement submitButton;
	
	@FindBy(xpath = "//strong[.='Well done!']")
	private WebElement welldoneText;
	
	
	
	
	//Initialization
	
	public AdminInsertProductPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	
	//Utilization


	public WebElement getAvailabilitySelect() {
		return availabilitySelect;
	}

	public WebElement getImageOneUploadButton() {
		return imageOneUploadButton;
	}

	public WebElement getImageTwoUploadButton() {
		return imageTwoUploadButton;
	}

	public WebElement getImageThreeUploadButton() {
		return imageThreeUploadButton;
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public WebElement getWelldoneText() {
		return welldoneText;
	}
	
	
	//Business library
	
	WebdriverUtility wUtil = new WebdriverUtility(driver);
	
	public void selectCategory(String visibleText ) {
		wUtil.selectDropdownByIndexOrVisibleText(categorySelect, visibleText);
	}
	
	public void selectSubcategory(String visibleText) {
		wUtil.selectDropdownByIndexOrVisibleText(subcategorySelect, visibleText);
	}
	
	public void selectAvailability(String visibleText) {
		wUtil.selectDropdownByIndexOrVisibleText(availabilitySelect, visibleText);
	}
	
	public void insertFirstSet(String name, String companyName, String beforeDiscount, String afterDiscount, String description, String shippingCharge) {
	
		nameTextfield.sendKeys(name);
		companyTextfield.sendKeys(companyName);
		priceBeforeDiscoutTextfield.sendKeys(beforeDiscount);
		priceAfterDiscoutTextfield.sendKeys(afterDiscount);
		descriptionTextfield.sendKeys(description);
		shippingchargeTextfield.sendKeys(shippingCharge);

	}
	
	public void imagePaths(String path1, String path2, String path3) {
		
		imageOneUploadButton.sendKeys(path1);
		imageTwoUploadButton.sendKeys(path2);
		imageThreeUploadButton.sendKeys(path3);
		
	}
	
}
