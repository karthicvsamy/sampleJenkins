package calendar.Handling.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboCalendarSearchTillFutureDate_Test {

	public static void main(String[] args) {
		
		String monthAndYear = "April 2025";
		int date = 2;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		driver.findElement(By.xpath("//span[.='Departure']/..")).click();
//		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
//		driver.findElement(By.xpath("//div[.='"+monthAndYear+"']/..//div[.='"+date+"']")).click();
		for(;;) {
		try {
		driver.findElement(By.xpath("//div[.='"+monthAndYear+"']/..//div[.='"+date+"']")).click();
		break;
		}
		catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		}
	}
}
