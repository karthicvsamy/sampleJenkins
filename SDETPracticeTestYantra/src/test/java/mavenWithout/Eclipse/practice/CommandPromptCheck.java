package mavenWithout.Eclipse.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CommandPromptCheck {

	public static WebDriver driver;
	@Test
	public void testOne() {
		
		String browser = System.getProperty("browser");
		String url = System.getProperty("url");
		String userName = System.getProperty("username");
		String password = System.getProperty("password");
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Browser name invalid");
		}
		
		driver.get(url);
		
		driver.findElement(By.name("email")).sendKeys(userName);;
		driver.findElement(By.name("password")).sendKeys(password);;
		driver.findElement(By.name("login")).click();
		
		
	}
}
