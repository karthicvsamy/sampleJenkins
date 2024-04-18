package com.alphaShoppee.elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alphaShoppee.genericUtility.WebdriverUtility;

public class AdminHomePage {
	
	WebDriver driver;
	
	
	@FindBy(xpath = "//a[contains(.,'Order Management')]")
	private WebElement orderManagementTab;
	
	@FindBy(xpath = "//a[contains(.,'Today')]")
	private WebElement todaysOrders;
	
	@FindBy(xpath = "//a[contains(.,'Pending Orders')]")
	private WebElement pendingOrders;
	
	@FindBy(xpath = "//a[contains(.,'Delivered Orders')]")
	private WebElement deliveredOrders;

	@FindBy(xpath = "//a[.=' Create Category ']/..")
	private WebElement createCategoryTab;
	
	@FindBy(xpath = "//a[.='Sub Category ']/..")
	private WebElement subcategoryTab;
	
	@FindBy(xpath = "//a[.='Insert Product ']/..")
	private WebElement insertProductTab;
	
	@FindBy(xpath = "//a[.='Manage Products ']/..")
	private WebElement manageProductsTab;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement profileDropdown;
	
	@FindBy(xpath = "//li[.='Logout']")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//span[.='You have successfully logout']")
	private WebElement logoutSuccessfulText;



	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}



	public WebElement getOrderManagementTab() {
		return orderManagementTab;
	}

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
	
	public WebElement getTodaysOrders() {
		return todaysOrders;
	}

	public WebElement getPendingOrders() {
		return pendingOrders;
	}

	public WebElement getDeliveredOrders() {
		return deliveredOrders;
	}
	
	public void logout() throws IOException {
		profileDropdown.click();
		logoutButton.click();

		if(logoutSuccessfulText.isDisplayed()) {
			System.out.println("Logout performed successfully");
		}
		else {
			System.out.println("Logout not performed properly");
		}
	}
	
	
}
