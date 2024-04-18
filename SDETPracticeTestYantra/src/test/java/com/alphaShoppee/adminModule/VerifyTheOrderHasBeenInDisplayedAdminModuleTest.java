package com.alphaShoppee.adminModule;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.alphaShoppee.elementRepository.AdminHomePage;
import com.alphaShoppee.elementRepository.AdminLoginPage;
import com.alphaShoppee.elementRepository.AdminOrdermanagementPage;
import com.alphaShoppee.elementRepository.UserCartPage;
import com.alphaShoppee.elementRepository.UserChoosePaymentPage;
import com.alphaShoppee.elementRepository.UserHomePage;
import com.alphaShoppee.elementRepository.UserLoginPage;
import com.alphaShoppee.elementRepository.UserProductPage;
import com.alphaShoppee.elementRepository.UserShoppingCartPage;
import com.alphaShoppee.genericUtility.BaseClass;

public class VerifyTheOrderHasBeenInDisplayedAdminModuleTest extends BaseClass {
	
	@Test(retryAnalyzer = com.alphaShoppee.genericUtility.RetryAnalyzerImplementationClass.class)
	
	public void verifyTheOrderHasBeenDisplayed() throws IOException {
		
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
		
		
		AdminLoginPage adminLogin = new AdminLoginPage(driver);
		adminLogin.adminLogin(eUtil.getStringDataFromExcel(adminSheet, 1, 1), eUtil.getStringDataFromExcel(adminSheet, 2, 1));
		
		AdminHomePage adminHome = new AdminHomePage(driver);
		
		adminHome.getOrderManagementTab().click();
		adminHome.getTodaysOrders().click();
		
		AdminOrdermanagementPage orderManagement = new AdminOrdermanagementPage(driver);
		orderManagement.getOrderSearchBar().sendKeys(eUtil.getStringDataFromExcel(sheetName, 12, 1)+Keys.ENTER);
		
		System.out.println(orderManagement.getTableFirstRowLastColumn().getText());
		System.out.println(eUtil.getStringDataFromExcel(sheetName, 3, 1));
		
		if(orderManagement.getTableFirstRowLastColumn().getText().equalsIgnoreCase(eUtil.getStringDataFromExcel(sheetName, 3, 1))) {
			System.out.println("The ordered product is visible in admin module");
		}
		else {
			System.out.println("The ordered product is not visible in admin module");
		}
		
	}

}
