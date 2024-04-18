package demoapps.Qspiders;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAllLinksFromAmazon {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		List<WebElement> links= driver.findElements(By.xpath("//a"));
		HashSet<WebElement> linkset = new HashSet<WebElement>(links);
		for(WebElement link : linkset) {
			System.out.println(link.getAttribute("href"));
		}
	}
}
