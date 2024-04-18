package myFirstPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindWhetherTheCountryNameExist {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.icc-cricket.com/rankings/team-rankings/mens/test");
		String countryName = "India";
		
		try {
			if(driver.findElement(By.xpath("//span[@class='si-fname si-text' and contains(.,'"+countryName+"')]")).isDisplayed()) {
				System.out.println("The country name is displayed");
			}
		}
		catch(NoSuchElementException nse) {
			System.out.println("The country name is not displayed");
		}
	}
}
