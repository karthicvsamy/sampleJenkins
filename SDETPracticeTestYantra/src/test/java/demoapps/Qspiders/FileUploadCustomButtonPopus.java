package demoapps.Qspiders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadCustomButtonPopus {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']/../..")).click();
		driver.findElement(By.xpath("//section[.='Popups']")).click();
		driver.findElement(By.xpath("//section[.='File Uploads']")).click();
		driver.findElement(By.xpath("//a[.='Custom Button']")).click();
		driver.findElement(By.xpath("//div[.='Upload File']")).click();
		Actions upload = new Actions(driver);
		upload.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		upload.sendKeys(Keys.TAB);
	}

}
