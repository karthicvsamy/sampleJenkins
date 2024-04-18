package com.alphaShoppee.adminModule;

import java.io.IOException;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import com.alphaShoppee.elementRepository.AdminHomePage;
import com.alphaShoppee.elementRepository.AdminLoginPage;
import com.alphaShoppee.elementRepository.AdminOrdermanagementPage;
import com.alphaShoppee.elementRepository.AdminProductStatusPage;
import com.alphaShoppee.elementRepository.UserCartPage;
import com.alphaShoppee.elementRepository.UserChoosePaymentPage;
import com.alphaShoppee.elementRepository.UserHomePage;
import com.alphaShoppee.elementRepository.UserLoginPage;
import com.alphaShoppee.elementRepository.UserProductPage;
import com.alphaShoppee.elementRepository.UserShoppingCartPage;
import com.alphaShoppee.genericUtility.BaseClass;

public class ViewTheDeliveredOrderTest extends BaseClass{
	
	@Test
	public void viewTheDeliveredOrderTest() throws IOException {
		
		
		String sheetName = "Purchase_Product_Test_Datas";
		String adminSheet = "Manage_Product_Test_Data";
		
		
		driver.get(eUtil.getStringDataFromExcel(sheetName, 0, 1));
		
		UserHomePage homepage = new UserHomePage(driver);
		UserLoginPage userLogin = new UserLoginPage(driver);
				
		homepage.getLoginTab().click();
		userLogin.loginToUser(eUtil.getStringDataFromExcel(sheetName, 1, 1), eUtil.getStringDataFromExcel(sheetName, 2, 1));

		
		if(homepage.getWelcomeText().isDisplayed()) {
			System.out.println("Logged in successfully");
		}
		else {
			System.out.println("Login is not successful");
		}
		
		
		homepage.getSearchBox().sendKeys(eUtil.getStringDataFromExcel(sheetName, 3, 1)+Keys.ENTER);
		homepage.clickRequiredProduct(eUtil.getStringDataFromExcel(sheetName, 3, 1));
		
		UserProductPage productPage = new UserProductPage(driver);
		productPage.getAddtocartButton().click();
		wUtil.acceptAlert();
		
		UserCartPage cartPage = new UserCartPage(driver);
		cartPage.getBasketIcon().click();
		cartPage.getMyCartButton().click();
		
		
		
		cartPage.updateBillingDetails(eUtil.getStringDataFromExcel(sheetName, 4, 1), eUtil.getStringDataFromExcel(sheetName, 5, 1), eUtil.getStringDataFromExcel(sheetName, 6, 1), eUtil.getStringDataFromExcel(sheetName, 7, 1));
		wUtil.acceptAlert();
		cartPage.updateShippingDetails(eUtil.getStringDataFromExcel(sheetName, 8, 1), eUtil.getStringDataFromExcel(sheetName, 9, 1), eUtil.getStringDataFromExcel(sheetName, 10, 1), eUtil.getStringDataFromExcel(sheetName, 11, 1));
		wUtil.acceptAlert();
		
		cartPage.getCheckoutButton().click();		
		UserChoosePaymentPage paymentPage = new UserChoosePaymentPage(driver);
		
		paymentPage.getInternetRadioButton().click();
		paymentPage.getSubmitButton().click();
		
		
		UserShoppingCartPage shoppingCart = new UserShoppingCartPage(driver);
		String tableData = shoppingCart.getTableLastRowThirdColumn().getText();
		String actualData = eUtil.getStringDataFromExcel(sheetName, 3, 1);
		
		
		if(actualData.equalsIgnoreCase(tableData)) {
			System.out.println("The order has been placed successfully");
		}
		else {
			System.out.println("The order placement is not successful");
		}
		
		driver.get(eUtil.getStringDataFromExcel(adminSheet, 0, 1));
		
		String parentId = driver.getWindowHandle();
				
		AdminLoginPage adminLogin = new AdminLoginPage(driver);
		adminLogin.adminLogin(eUtil.getStringDataFromExcel(adminSheet, 1, 1), eUtil.getStringDataFromExcel(adminSheet, 2, 1));

		AdminHomePage adminHome = new AdminHomePage(driver);
		
		adminHome.getOrderManagementTab().click();
		
		adminHome.getPendingOrders().click();
		AdminOrdermanagementPage orderManagement = new AdminOrdermanagementPage(driver);
		orderManagement.getOrderSearchBar().sendKeys(eUtil.getStringDataFromExcel(sheetName, 12, 1));
		
		
		try {
		orderManagement.searchProduct(eUtil.getStringDataFromExcel(sheetName, 3, 1));
		}
		catch (ElementNotInteractableException enie){
			System.out.println("The edit icon is not visible and entered catch block");
			String link = orderManagement.getTheActionLink(eUtil.getStringDataFromExcel(sheetName, 3, 1));
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(link);			
		}
			
		AdminProductStatusPage statusPage = new AdminProductStatusPage(driver);
		statusPage.changeToDelivered(eUtil.getStringDataFromExcel(adminSheet, 20, 1), eUtil.getStringDataFromExcel(adminSheet, 20, 1));
		
		wUtil.acceptAlert();
		driver.close();
		driver.switchTo().window(parentId);
				
		
		adminHome.getOrderManagementTab().click();
		adminHome.getDeliveredOrders().click();
		orderManagement.getOrderSearchBar().sendKeys(eUtil.getStringDataFromExcel(sheetName, 12, 1)+Keys.ENTER);
				
		if(orderManagement.dataIsPresentOrNot(eUtil.getStringDataFromExcel(sheetName, 3, 1))) {
			System.out.println("The order has been delivered");
		}
		else {
			System.out.println("The order is not yet delivered");
		}
		
				
	}

}
