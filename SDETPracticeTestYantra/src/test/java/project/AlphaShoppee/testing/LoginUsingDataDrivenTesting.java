package project.AlphaShoppee.testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginUsingDataDrivenTesting {

	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties propObj = new Properties();
		propObj.load(fis);
		
		if(propObj.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(propObj.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("default browser choosen");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		/* LOGIN AS AN ADMIN */
		
		driver.get(propObj.getProperty("adminUrl"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.findElement(By.name("username")).sendKeys(propObj.getProperty("adminUsername"));
		driver.findElement(By.name("password")).sendKeys(propObj.getProperty("adminPassword"));
		driver.findElement(By.name("submit")).click();
		
		/* LOGIN AS AN USER */
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(propObj.getProperty("userUrl"));
		
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.name("email")).sendKeys(propObj.getProperty("userUsername")); 
		driver.findElement(By.name("password")).sendKeys(propObj.getProperty("userPassword"));
		driver.findElement(By.name("login")).click();

	}
}
