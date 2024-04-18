package project.AlphaShoppee.testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DeleteCategoryFromAdminModuleTest {

	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("browser name not valids");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("adminUrl"));
		
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("adminUsername"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("adminPassword"));
		driver.findElement(By.xpath("//button[.='Login']")).click();
		
		driver.findElement(By.xpath("//li[.=' Create Category ']")).click();
		String parentId = driver.getWindowHandle();
//		List<WebElement> allSigns= driver.findElements(By.xpath("//i[@class='icon-remove-sign']"));
//		for(WebElement sign : allSigns) {
//			sign.click();
//			driver.switchTo().alert().accept();
//			driver.switchTo().window(parentId);
//		}
		for(int i=0;i<100;i++) {
//		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("//i[@class='icon-remove-sign']")).click();
		driver.switchTo().alert().accept();
		}
	}
	
}
