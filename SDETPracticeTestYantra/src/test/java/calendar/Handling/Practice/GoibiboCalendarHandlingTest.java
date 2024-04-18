package calendar.Handling.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboCalendarHandlingTest {
	
	public static void main(String[] args) {
		
		String monthAndYear = "March 2024";
		int date = 27;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		driver.findElement(By.xpath("//span[.='Departure']/..")).click();
		driver.findElement(By.xpath("//div[.='"+monthAndYear+"']/..//div[.='"+date+"']")).click();
	
	}

}
