package demoapps.Qspiders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import demo.Qspiders.WebdriverUtility;

public class HandlingMultipleWindows {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']/../..")).click();
		driver.findElement(By.xpath("//section[.='Popups']")).click();
		driver.findElement(By.xpath("//section[.='Browser Windows']")).click();
		driver.findElement(By.xpath("//a[.='Multiple Windows']")).click();
		driver.findElement(By.id("browserButton3")).click();
//		Set<String> presentWindows = driver.getWindowHandles();
//		for(String wid : presentWindows) {
//			driver.switchTo().window(wid);
//			if(driver.getCurrentUrl().contains("SignUp")) {
//				break;
//			}
//		}
//		System.out.println(driver.getWindowHandles()+" ");
		WebdriverUtility utilize = new WebdriverUtility();
//		utilize.switchWindowWithPartialUrl(driver, "SignUpPage");
//		String signUpPageId = driver.getWindowHandle();
//		utilize.switchWindowWithPartialUrl(driver, "SignUp");
//		String signUpId = driver.getWindowHandle();
//		System.out.println(signUpPageId + " " + signUpId);
		utilize.switchWindowWithPartialUrl(driver, "SignUpPage");
		driver.findElement(By.id("email")).sendKeys("nothingserious@gmail.com");
		utilize.switchWindowWithPartialUrl(driver, "SignUp");
		driver.findElement(By.id("username")).sendKeys("thisisfunny");
		utilize.switchWindowWithPartialUrl(driver, "SignUpPage");
		driver.findElement(By.id("password")).sendKeys("yeah");
		utilize.switchWindowWithPartialUrl(driver, "SignUp");
		driver.findElement(By.id("email")).sendKeys("hahahaha@gmail.com");
	}
	
}
