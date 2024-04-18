package demoapps.Qspiders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDivisionPopup {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']/../..")).click();
		driver.findElement(By.xpath("//section[.='Popups']")).click();
		driver.findElement(By.xpath("//section[.='Hidden division']")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text' and @class='w-full h-10 px-4 m-2 border-2 border-stone-600 rounded-md']")).click();
//		driver.findElement(By.xpath("//div[.='Name']//input[@type='text']")).click();
		driver.findElement(By.xpath("//div[.='Name']//input[@type='text']")).sendKeys("Whyso");
		driver.findElement(By.xpath("//div[.='Email']//input[@type='email']")).sendKeys("whysoserios@gmail.com");
	}
}
