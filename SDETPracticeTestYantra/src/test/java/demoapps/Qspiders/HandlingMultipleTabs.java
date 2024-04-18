package demoapps.Qspiders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import demo.Qspiders.WebdriverUtility;

public class HandlingMultipleTabs {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']/../..")).click();
		driver.findElement(By.xpath("//section[.='Popups']")).click();
		driver.findElement(By.xpath("//section[.='Browser Windows']")).click();
		driver.findElement(By.xpath("//a[.='Multiple Tabs']")).click();
		driver.findElement(By.id("browserButton2")).click();
		System.out.println(driver.getWindowHandles()+" ");
		WebdriverUtility utility = new WebdriverUtility();
		utility.switchWindowWithPartialUrl(driver, "SignUp");
		System.out.println(driver.getWindowHandle());
		utility.switchWindowWithPartialUrl(driver, "SignUpPage");
		System.out.println(driver.getWindowHandle());
	}
}
