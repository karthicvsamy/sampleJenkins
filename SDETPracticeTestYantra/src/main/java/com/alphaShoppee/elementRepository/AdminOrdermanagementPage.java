package com.alphaShoppee.elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminOrdermanagementPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//label[.='Search: ']/input")
	private WebElement orderSearchBar;
	
	@FindBy(xpath = "//table/tbody/tr[last()]/td[5]")
	private WebElement tableFirstRowLastColumn;
	
	@FindBy(xpath = "//table/tbody/tr/td[5]")
	private List<WebElement> fifthColumnDatas;
	
	
	
	public AdminOrdermanagementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}


	public WebElement getOrderSearchBar() {
		return orderSearchBar;
	}
	
	public WebElement getTableFirstRowLastColumn() {
		return tableFirstRowLastColumn;
	}
	
	public void searchProduct(String productName) {
		driver.findElement(By.xpath("//table/tbody/tr/td[.='"+productName+"'][1]/..//a")).click();
	}
	
	public String getTheActionLink(String productName) {
		return driver.findElement(By.xpath("//table/tbody/tr/td[.='"+productName+"'][1]/..//a")).getAttribute("href");
	}
	
	public boolean dataIsPresentOrNot(String toCheckData) {
		for(WebElement ele:fifthColumnDatas) {
			if(ele.getText().equalsIgnoreCase(toCheckData)) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
