package calendar.Handling.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IrctcCalendarHandlingTest {

	public static void main(String[] args) {
		
		String  date = "15", month = "July", year = "2024";
		ChromeOptions cOption = new ChromeOptions();
		cOption.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(cOption);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.id("jDate")).click();
		for(;;) {
		try {
		driver.findElement(By.xpath("//span[.='"+month+"']/following-sibling::span[.='"+year+"']/ancestor::div[contains(@class,'ui-datepicker-group')]//td/a[.='"+date+"']")).click();
		break;
		}
		catch(NoSuchElementException nse) {
			driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-next')]")).click();
		}
		}
	}
}
