package demoapps.Qspiders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import demo.Qspiders.WebdriverUtility;

public class AuthenticationPopup {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']/../..")).click();
		driver.findElement(By.xpath("//section[.='Popups']")).click();
		driver.findElement(By.xpath("//section[.='Authentication']")).click();
		driver.findElement(By.id("AuthLink")).click();
		String username = "admin";
		String password = "admin";
		WebdriverUtility utilize = new WebdriverUtility();
		utilize.switchWindowWithPartialUrl(driver, "projects");
		driver.get("https://"+username+":"+password+"@"+"basic-auth-git-main-shashis-projects-4fa03ca5.vercel.app/");
;	}
}
