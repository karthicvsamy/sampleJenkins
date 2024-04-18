package selenium.Assignments;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonColourFetchTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		String parentID = driver.getWindowHandle();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 15"+Keys.ENTER);
		driver.findElement(By.xpath("//img[@alt='Sponsored Ad - Apple iPhone 15 (128 GB) - Blue']")).click();
		Set<String> presentWindows = driver.getWindowHandles();
		for(String wid : presentWindows) {
			driver.switchTo().window(wid);
			if(!wid.equals(parentID)) {
				break;
			}
		}
		List<WebElement> colours = driver.findElements(By.xpath("//span[@class='xoverlay']/../div/div/img"));
		for(WebElement eachElement : colours) {
			System.out.println(eachElement.getAttribute("alt"));	
		}
//		System.out.println(driver.getCurrentUrl());
		
		
		////div[@id='variation_color_name']/ul[@role='radiogroup']/li
	}
}
