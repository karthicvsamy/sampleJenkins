package demoapps.Qspiders;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavascriptPopup {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']/../..")).click();
		driver.findElement(By.xpath("//section[text()='Popups']/..")).click();
		driver.findElement(By.xpath("//section[text()='Javascript']/..")).click();
		driver.findElement(By.id("buttonAlert2")).click();
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//a[text()='Confirm']")).click();
		driver.findElement(By.id("buttonAlert5")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[text()='Prompt']")).click();
		driver.findElement(By.id("buttonAlert1")).click();
		WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitDriver.until(ExpectedConditions.alertIsPresent());
		Alert promptAlert = driver.switchTo().alert();
		String alertText = promptAlert.getText();
		System.out.println(alertText);
		promptAlert.sendKeys("Yes");
		driver.switchTo().alert().accept();
		
	}

}
