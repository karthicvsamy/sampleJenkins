package calendar.Handling.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KsrtcCalenderHandling {
	
	public static void main(String[] args) {
		
		String date="24", month = "April", year = "2024";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.get("https://www.ksrtc.in/oprs-web/");
		driver.findElement(By.id("txtJourneyDate")).click();
		
		for(;;) {
		try {
			driver.findElement(By.xpath("//span[contains(.,'"+month+"')]/following-sibling::span[.='"+year+"']/ancestor::div[@id='ui-datepicker-div']//td[.='"+date+"']")).click();
			break;
		}
		catch(NoSuchElementException nse) {
			driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-next')]")).click();
		}
		
		}
	}

}
