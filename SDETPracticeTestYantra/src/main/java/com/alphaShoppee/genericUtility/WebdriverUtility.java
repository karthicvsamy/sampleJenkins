package com.alphaShoppee.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebdriverUtility {

	WebDriver driver;
	
	
	
	
	//DRIVER INITIALIZER THROUGH CONSTRUCTOR//
	
	/**
	 * This is the constructor to initialize the driver
	 * @param driver
	 */
	public WebdriverUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/**
	 * This method is used to maximize the window
	 */
	public void maximizeTheScreen() {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to wait until the page gets fully loaded
	 * @param sec
	 */
	public void pageLoadingTime(int sec) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	
	
	
	//IMPLICIT wAIT//
	/**
	 * This method is used to implement the implicitlyWait method
	 * @param sec
	 */
	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	
	
	
	//EXPLICIT WAIT//
	
	/**
	 * This method is used to initialize the implicitly wait by returning the reference of the webdriverWait object
	 * @param sec
	 * @return
	 */
	public WebDriverWait initializeExplicitlyWait(int sec) {
		WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wdw;
	}
	/**
	 * This method is used to make driver wait until the given element is visible within the given time
	 * @param element
	 * @param sec
	 */
	public void visibilityWait(WebElement element, int sec) {
		initializeExplicitlyWait(sec).until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method makes the driver wait until the given element turns to clickable state within the given time
	 * @param element
	 * @param sec
	 */
	public void clickableWait(WebElement element,int sec) {
		initializeExplicitlyWait(sec).until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method makes the driver wait until the page title contains the given string for the given time
	 * @param element
	 * @param sec
	 * @param partialTitle
	 */
	public void titleContainsWait(WebElement element, int sec, String partialTitle) {
		initializeExplicitlyWait(sec).until(ExpectedConditions.titleContains(partialTitle));
	}
	
	
	
	
	//ACTIONS CLASS//
	/**
	 * This method creates the object for the Actions class and return the reference
	 * @return
	 */
	public Actions initializeActions() {
		Actions action = new Actions(driver);
		return action;
	}
	/**
	 * This method is used to click on the element
	 * @param element
	 */
	public void clickElement(WebElement element) {
		initializeActions().click(element).perform();
	}
	/**
	 * This method drags and drops the given element into the target location
	 * @param element
	 * @param target
	 */
	public void dragAndDropElement(WebElement element, WebElement target) {
		initializeActions().dragAndDrop(element, target).perform();
	}
	
	public void dragAndDropByOffset(WebElement element, int xOffset, int yOffset) {
		initializeActions().dragAndDropBy(element, xOffset, yOffset);
	}
	
	public void doubleClickElement(WebElement element) {
		initializeActions().doubleClick(element).perform();
	}
	
	public void rightClickElement(WebElement element) {
		initializeActions().contextClick(element).perform();
	}
	
	
	
	
	//ALERT//
	
	public Alert switchToAlert() {
		return driver.switchTo().alert();
	}
	
	public void acceptAlert() {
		switchToAlert().accept();
	}
	
	public void dismissAlert() {
		switchToAlert().dismiss();
	}
	
	public void sendDataToAlertAndAccept(String data) {
		switchToAlert().sendKeys(data);
		switchToAlert().accept();
	}
	
	
	
	
	//FRAMES//
	
	public TargetLocator initializeSwitchTOFrame() {
		return driver.switchTo();
	}
	
	public void switchToFrame(int index) {
		initializeSwitchTOFrame().frame(index);
	}
	
	public void switchToFrame(String name) {
		initializeSwitchTOFrame().frame(name);
	}
	
	public void switchToFrame(WebElement element) {
		initializeSwitchTOFrame().frame(element);
	}
	
	public void switchFrameToParent() {
		initializeSwitchTOFrame().parentFrame();
	}
	
	public void switchFrameToDefaultContent() {
		initializeSwitchTOFrame().defaultContent();
	}
	
	
	
	//SELECT CLASS//
	
	public Select initializeSelectClass(WebElement element) {
		return new Select(element);
	}
	
	public void selectDropdownByIndexOrVisibleText(WebElement element, String visibleText) {
		initializeSelectClass(element).selectByVisibleText(visibleText);
	}
	
	public void selectDropdownByIndexOrVisibleText(WebElement element, int index) {
		initializeSelectClass(element).selectByIndex(index);
	}
	
	public void selectDropdownByValue(WebElement element, String value) {
		initializeSelectClass(element).selectByValue(value);
	}
	
	
	
	//JAVASCRIPT//
	
	public JavascriptExecutor initializeJavascriptExecutor() {
		return (JavascriptExecutor)driver;
	}
	
	public void scrollTillBottomOfPage() {
		initializeJavascriptExecutor().executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scrollTillTopOfPage() {
		initializeJavascriptExecutor().executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	public void scrollTillElement(WebElement element) {
		initializeJavascriptExecutor().executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public void sendDataToElementUsingJSE(WebElement element, String data) {
		initializeJavascriptExecutor().executeScript("arguments[0].value=arguments[1]", element, data);
	}
	
	public void clickOnElementUsingJSE(WebElement element) {
		initializeJavascriptExecutor().executeScript("arguments[0].click()", element);
	}
	
	public void scrollToElementUsingJSEOffset(WebElement element) {
		Point point = element.getLocation();
		int xOffset = point.getX();
		int yOffset = point.getY();
		initializeJavascriptExecutor().executeScript("window.scrollBy("+xOffset+","+yOffset+")");
	}
	
	
	
	//TAKE SCREENSHOT//
	
	public String takeScreenshotOfDriver() throws IOException {
		TakesScreenshot tss = (TakesScreenshot)driver;
		File temporaryFile = tss.getScreenshotAs(OutputType.FILE);
		File permenantFile = new File(".\\screenshots\\defectDriver"+new Date().toString().replace(' ','-').replace(':', '-')+".png");
		Files.copy(temporaryFile, permenantFile);
		return permenantFile.getAbsolutePath();
	}
	
	public void takeScreenshotOfElement(WebElement element) throws IOException {
		File temporaryFile = element.getScreenshotAs(OutputType.FILE);
		File permenantFile = new File(".\\screenshots\\defectElement"+new Date().toString().replace(' ','-').replace(':','-')+".png");
		Files.copy(temporaryFile, permenantFile);
	}
}
