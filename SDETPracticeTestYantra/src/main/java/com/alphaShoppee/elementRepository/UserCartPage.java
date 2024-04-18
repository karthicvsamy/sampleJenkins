package com.alphaShoppee.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserCartPage {

	@FindBy(xpath = "//div[@class='basket']")
	private WebElement basketIcon;
	
	@FindBy(xpath = "//div[@class='clearfix cart-total']/a")
	private WebElement myCartButton;
	
	@FindBy(name = "billingaddress")
	private WebElement billingAddress;
	
	@FindBy(name = "bilingstate")
	private WebElement billingState;
	
	@FindBy(name = "billingcity")
	private WebElement billingCity;
	
	@FindBy(name = "billingpincode")
	private WebElement billingPincode;
	
	@FindBy(name = "update")
	private WebElement updateBillingButton;
	
	@FindBy(name = "shippingaddress")
	private WebElement shippingAddress;
	
	@FindBy(name = "shippingstate")
	private WebElement shippingState;
	
	@FindBy(name = "shippingcity")
	private WebElement shippingCity;
	
	@FindBy(name = "shippingpincode")
	private WebElement shippingPincode;
	
	@FindBy(name = "shipupdate")
	private WebElement updateShippingButton;
	
	@FindBy(name = "ordersubmit")
	private WebElement checkoutButton;
	

	

	public UserCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public WebElement getBasketIcon() {
		return basketIcon;
	}

	public WebElement getMyCartButton() {
		return myCartButton;
	}
	
	public WebElement getCheckoutButton() {
		return checkoutButton;
	}
	
	
	
	
	public void updateBillingDetails(String bAddress, String bState, String bCity, String bPincode) {
		billingAddress.clear();
		billingAddress.sendKeys(bAddress);
		billingState.clear();
		billingState.sendKeys(bState);
		billingCity.clear();
		billingCity.sendKeys(bCity);
		billingPincode.clear();
		billingPincode.sendKeys(bPincode);
		updateBillingButton.click();
	}
	
	public void updateShippingDetails(String sAddress, String sState, String sCity, String sPincode) {
		shippingAddress.clear();
		shippingAddress.sendKeys(sAddress);
		shippingState.clear();
		shippingState.sendKeys(sState);
		shippingCity.clear();
		shippingCity.sendKeys(sCity);
		shippingPincode.clear();
		shippingPincode.sendKeys(sPincode);
		updateShippingButton.click();
	}
	
}
